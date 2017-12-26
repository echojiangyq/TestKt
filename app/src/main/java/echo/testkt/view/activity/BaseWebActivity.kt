package echo.testkt.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import echo.testkt.R
import kotlinx.android.synthetic.main.activity_base_web.*
import java.net.URLDecoder

/**
 * 作者：EchoJ on 2017/12/21 17:18 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
class BaseWebActivity :AppCompatActivity(){
    
    var url = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_web)

        url = URLDecoder.decode(intent.data.toString())

        wvWeb.loadUrl(url)
        wvWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
    }
}