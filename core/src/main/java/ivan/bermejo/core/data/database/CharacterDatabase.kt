package ivan.bermejo.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import ivan.bermejo.core.data.database.dao.CharacterDao
import ivan.bermejo.core.data.database.entities.CharacterEntity
import ivan.bermejo.core.data.model.Character
import ivan.bermejo.core.data.model.LocationCharacter
import ivan.bermejo.core.data.model.Origin

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun getCharacterDao():CharacterDao
}