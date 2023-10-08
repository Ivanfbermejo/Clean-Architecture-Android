package ivan.bermejo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ivan.bermejo.domain.model.ViewData
import ivan.bermejo.domain.useCase.GetDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class VMCharacter: ViewModel() {

    private val getDataUseCase: GetDataUseCase by inject(GetDataUseCase::class.java)
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    init {
        getAllData()
    }

    private fun getAllData() {
        viewModelScope.launch {
            getDataUseCase.requestViewData()

            getDataUseCase.viewData.collect {
                _state.value = UiState(viewData = it)
            }
        }
    }
    fun onMovieClick(viewData: ViewData) {
        viewModelScope.launch {
            getDataUseCase.updateViewData(viewData)
        }
    }
    data class UiState(
        var viewData: List<ViewData> = listOf()
    )
}