package ivan.bermejo.data.rickandmorty.model.character

import ivan.bermejo.domain.model.ViewData

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
fun Result.toViewData(): ViewData{
    return ViewData(id, name, image)
}