import com.google.gson.annotations.SerializedName


data class Json4Kotlin_Base (

	@SerializedName("_total") val _total : Int,
	@SerializedName("top") val top : List<Top>
)