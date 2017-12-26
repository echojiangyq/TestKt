package echo.testkt.mvp.contract

import echo.testkt.bean.FuckGood
import echo.testkt.bean.JsonResult
import rx.Observable

/**
 * 作者：EchoJ on 2017/12/18 17:05 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
interface FuckGoodContract {
    
    interface Model{
        fun getData(page:Int): Observable<JsonResult<List<FuckGood>>>
    }
    
    interface View{
        fun setData(data: List<FuckGood>)
    }

    /**
     * open 就是可以继承
     */
    interface Presenter{
        open fun getData(page:Int)
    }
}