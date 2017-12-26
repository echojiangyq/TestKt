package echo.testkt.di.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import echo.testkt.api.GankApi
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Singleton

/**
 * 作者：EchoJ on 2017/12/18 17:52 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */

@Module(includes = [(AppModule::class)])
class ApiModule {
    
    companion object {
        val BASE_URL = "http://gank.io/api/"
    }

    @Provides fun provideApi(retrofit: Retrofit) = retrofit.create(GankApi::class.java)
    
    @Provides @Singleton
    fun provideRetrofig(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson) =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()
    
    @Provides fun provideHttpUrl() = HttpUrl.parse(BASE_URL)
    
    @Provides fun provideOkhttpClient(context: Context, interceptor: HttpLoggingInterceptor): OkHttpClient {
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor).build()
    }
    
    @Provides fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
    
    @Provides fun provideGson() = GsonBuilder().create()

}