package echo.testkt.bean

/**
 * 作者：EchoJ on 2017/12/18 16:45 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
data class FuckGood(
        val _id: String,
        val createdAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String) {

    fun hasImg() = images != null

    fun create() = createdAt.substring(0, 10)
}