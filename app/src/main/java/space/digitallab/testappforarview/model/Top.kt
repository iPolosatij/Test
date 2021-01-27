import com.google.gson.annotations.SerializedName



data class Top (

	@SerializedName("channels") val channels : Int,
	@SerializedName("viewers") val viewers : Int,
	@SerializedName("game") val game : Game
)