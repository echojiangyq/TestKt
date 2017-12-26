package echo.testkt

import android.app.Application
import echo.testkt.di.component.ApiComponent
import echo.testkt.di.component.DaggerApiComponent
import echo.testkt.di.module.ApiModule
import echo.testkt.di.module.AppModule
import javax.inject.Inject

/**
 * 作者：EchoJ on 2017/12/18 16:19 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
class App: Application() {
    
    companion object {
        lateinit var instance: App
    }
    
    init {
        instance = this
    }

    @Inject lateinit var  apiComponent: ApiComponent 
    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }
}