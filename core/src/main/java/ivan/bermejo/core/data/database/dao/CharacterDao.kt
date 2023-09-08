package ivan.bermejo.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ivan.bermejo.core.data.database.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    suspend fun getAllCharacter():List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<CharacterEntity>)

    @Query("DELETE FROM character_table")
    suspend fun deleteAllCharacter()
}