package ivan.bermejo.core.data.model

data class InputObjectLocation (
    var info: Info,
    var results: List<Location>
)
data class Location(
    var id: Int,
    var name: String,
    var type: String,
    var dimension: String,
    var residents: List<String>,
    var url: String,
    var created: String
)