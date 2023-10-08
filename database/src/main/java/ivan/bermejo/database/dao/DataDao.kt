package ivan.bermejo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ivan.bermejo.database.entities.DataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    fun getAll(): Flow<List<DataEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<DataEntity>)

    @Query("DELETE FROM character_table")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM character_table")
    suspend fun count(): Int

    @Update
    suspend fun update(dataEntity: DataEntity)
}