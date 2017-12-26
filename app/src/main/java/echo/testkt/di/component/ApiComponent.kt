package echo.testkt.di.component

import com.google.gson.Gson
import dagger.Component
import echo.testkt.App
import echo.testkt.di.module.ApiModule
import echo.testkt.di.module.FuckGoodModule
import javax.inject.Singleton

/**
 * 作者：EchoJ on 2017/12/18 17:50 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
@Singleton
@Component(modules = [(ApiModule::class)])
interface ApiComponent {
    fun inject(app: App) 
    fun getFuckGood(fuckGoodModule: FuckGoodModule): FuckGoodComponent
    fun getGson(): Gson
}