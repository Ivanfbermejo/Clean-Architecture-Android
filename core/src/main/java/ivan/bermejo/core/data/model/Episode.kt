package ivan.bermejo.core.data.model

import com.google.gson.annotations.SerializedName

data class InputObjectEpisode (
    var info: Info,
    var results: List<Episode>
)
data class Episode(
    var id: Int,
    var name: String,
    @SerializedName("air_date") var airDate: String,
    var episode: String,
    var characters: List<String>,
    var url: String,
    var created: String
)