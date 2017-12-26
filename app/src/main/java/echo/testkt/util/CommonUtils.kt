package echo.testkt.util

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * 作者：EchoJ on 2017/12/18 17:46 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
object CommonUtils {
    
    fun loge(msg: String) = Log.e("test", msg)
    
    fun logd(msg: String) = Log.d("test", msg)


    fun loadImage(imageView: ImageView, url: String?) =
            Glide.with(imageView.context).load(url)
                    .crossFade()
                    .into(imageView)

    fun loadAsset(imageView: ImageView, id:Int) =
            Glide.with(imageView.context).load(id).into(imageView)
}