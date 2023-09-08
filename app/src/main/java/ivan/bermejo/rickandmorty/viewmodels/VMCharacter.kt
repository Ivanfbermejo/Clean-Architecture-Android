package ivan.bermejo.rickandmorty.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ivan.bermejo.core.data.database.dao.CharacterDao
import ivan.bermejo.core.data.database.entities.toDatabase
import ivan.bermejo.core.data.model.Character
import ivan.bermejo.core.data.model.toModel
import ivan.bermejo.core.data.network.IApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class VMCharacter(private var characterDao: CharacterDao, private var apiHelper: IApiHelper): ViewModel() {

    private var _character = MutableLiveData<List<Character>>()
    val character: List<Character> get() = _character.value!!

    private val _isLoaded = MutableStateFlow(false)
    val isLoaded: StateFlow<Boolean> = _isLoaded


    init {
        _character.postValue(listOf())
        getAllCharacter()
    }

    private fun getAllCharacter() {
        viewModelScope.launch {
            apiHelper.getAllCharacter()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    Log.e("ERROR", e.toString())
                    var category = characterDao.getAllCharacter().map { it.toModel() }
                    _character.postValue(category)
                    _isLoaded.value = true
                }
                .collect {
                    _character.postValue(it)
                    characterDao.deleteAllCharacter()
                    characterDao.insertAll(it.map { character-> character.toDatabase() })
                    _isLoaded.value = true
                }
        }
    }
}