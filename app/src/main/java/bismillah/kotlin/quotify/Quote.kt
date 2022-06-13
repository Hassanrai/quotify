package bismillah.kotlin.quotify

import com.google.gson.annotations.SerializedName

data class Quote(

    var text: String,
    @SerializedName("author")
    var name: String? = null
)
