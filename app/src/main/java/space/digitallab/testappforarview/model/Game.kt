import com.google.gson.annotations.SerializedName




data class Game (

	@SerializedName("_id") val _id : Int,
	@SerializedName("box") val box : Box,
	@SerializedName("giantbomb_id") val giantbomb_id : Int,
	@SerializedName("logo") val logo : Logo,
	@SerializedName("name") val name : String
)