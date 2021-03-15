package dev.withjs.pen

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import android.webkit.JavascriptInterface
import android.widget.Toast


/** Instantiate the interface and set the context  */
class WebAppInterface(private val mContext: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }

    /** switch mode */
    @JavascriptInterface
    fun windowSoftInputMode(mode: String){
//        showToast(mode)
        if(mode=="pan"){
            showToast("switch to pan")
            (mContext as MainActivity).runOnUiThread(Runnable {
                (mContext as MainActivity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            })
//            (mContext as MainActivity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN )
        } else {
            showToast("switch to resize")
            (mContext as MainActivity).runOnUiThread(Runnable {
                (mContext as MainActivity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
            })
        }
    }
}