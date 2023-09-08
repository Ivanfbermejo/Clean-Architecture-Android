package ivan.bermejo.core.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import ivan.bermejo.core.data.model.Character

@Entity(tableName = "character_table")
class CharacterEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "character") val character: String
)

fun Character.toDatabase() = CharacterEntity(character = Gson().toJson(this).toString())