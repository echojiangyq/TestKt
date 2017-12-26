package echo.testkt.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * 作者：EchoJ on 2017/12/18 17:52 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
@Module
class AppModule (private val app: Context){
   @Provides fun provideApp() = app
}