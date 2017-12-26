package echo.testkt.di.module

import dagger.Module
import dagger.Provides
import echo.testkt.mvp.contract.FuckGoodContract

/**
 * 作者：EchoJ on 2017/12/18 17:52 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */

@Module
class FuckGoodModule (private val view: FuckGoodContract.View){
    @Provides fun provideView() = view
}