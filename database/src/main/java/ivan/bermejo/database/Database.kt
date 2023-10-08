package ivan.bermejo.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ivan.bermejo.database.dao.DataDao
import ivan.bermejo.database.entities.DataEntity

@Database(entities = [DataEntity::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getDao(): DataDao
}