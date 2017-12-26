package echo.testkt.mvp.model

import echo.testkt.api.GankApi
import echo.testkt.bean.FuckGood
import echo.testkt.bean.JsonResult
import echo.testkt.mvp.contract.FuckGoodContract
import rx.Observable
import javax.inject.Inject

/**
 * 作者：EchoJ on 2017/12/18 17:25 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
class FuckGoodModelImpl 
@Inject constructor(private val api: GankApi) : FuckGoodContract.Model {
    
    override fun getData(page: Int): Observable<JsonResult<List<FuckGood>>> {
        return api.getAndroidData(page)
    }
    
}