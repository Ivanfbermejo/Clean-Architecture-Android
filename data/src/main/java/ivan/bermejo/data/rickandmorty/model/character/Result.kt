package ivan.bermejo.data.rickandmorty.model.character

import ivan.bermejo.domain.model.ViewData

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    override val image: String,
    val location: Location,
    override val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) :ViewData