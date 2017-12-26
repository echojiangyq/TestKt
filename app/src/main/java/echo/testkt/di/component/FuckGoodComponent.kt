package echo.testkt.di.component

import dagger.Subcomponent
import echo.testkt.di.module.FuckGoodModule
import echo.testkt.view.activity.FuckGoodActivity

/**
 * 作者：EchoJ on 2017/12/18 17:50 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
@Subcomponent(modules = [(FuckGoodModule::class)])
interface FuckGoodComponent {
    fun inject(activity: FuckGoodActivity)
}