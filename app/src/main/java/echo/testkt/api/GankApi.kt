package echo.testkt.api

import echo.testkt.bean.FuckGood
import echo.testkt.bean.JsonResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * 作者：EchoJ on 2017/12/18 16:51 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 */
interface GankApi {
    
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int): Observable<JsonResult<List<FuckGood>>>
    
}