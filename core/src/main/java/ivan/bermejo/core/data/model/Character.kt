package ivan.bermejo.core.data.model

import com.google.gson.Gson
import ivan.bermejo.core.data.database.entities.CharacterEntity

data class InputObjectCharacter (
    var info: Info,
    var results: List<Character>
)
data class Character (
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: Origin,
    var location: LocationCharacter,
    var image: String,
    var episode: List<String>,
    var url: String,
    var created: String
)

data class Origin (
    var name: String,
    var url: String
)

data class LocationCharacter (
    var name: String,
    var url: String
)


fun CharacterEntity.toModel() = Gson().fromJson(this.character, Character::class.java)