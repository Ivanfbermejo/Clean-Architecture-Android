package ivan.bermejo.domain.model
data class ViewData (
    val id: Int,
    val name: String,
    val image: String,
    val favorite: Boolean = false
)