package ivan.bermejo.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ivan.bermejo.domain.model.ViewData


@Entity(tableName = "character_table")
class DataEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "favorite") val favorite: Boolean = false
)
fun DataEntity.toViewData(): ViewData{
    return ViewData(name = name, image = image, id = id, favorite = favorite)
}
fun ViewData.toDataEntity(): DataEntity{
    return DataEntity(image = image, name = name, id = id, favorite = favorite)
}