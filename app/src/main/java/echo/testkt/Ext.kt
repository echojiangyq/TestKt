package echo.testkt

import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * 作者：EchoJ on 2017/12/18 16:23 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
    
fun Context.toast(msg:String, length:Int = Toast.LENGTH_SHORT)= Toast.makeText(this, msg, length).show()

fun Context.toActivity(clz:Class<*>) = startActivity(Intent(this, clz))

fun Context.getApiComponet() = App.instance.apiComponent