package echo.testkt.mvp.presenter

import echo.testkt.mvp.contract.FuckGoodContract
import echo.testkt.mvp.model.FuckGoodModelImpl
import echo.testkt.util.CommonUtils
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * 作者：EchoJ on 2017/12/18 17:25 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
class FuckGoodPresenterImpl
   @Inject constructor(private val m: FuckGoodModelImpl, 
                       private val v: FuckGoodContract.View) : FuckGoodContract.Presenter, BasePresenter(){
    
    override fun getData(page:Int) {
        addSubscription(m.getData(page).observeOn(AndroidSchedulers.mainThread()).subscribe(
                { res ->
                    run {
                        if (!res.error) {
                            v.setData(res.results)
                        }
                    }
                }, 
                
                { e -> 
                    run { 
                        CommonUtils.loge("presenter err: " + e.message) 
                    } 
                }
        ))
    }
}