package com.shashank.platform.fancyflashbarlibrary

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.shashank.platform.fancyflashbarlib.Flashbar
import com.shashank.platform.fancyflashbarlib.anim.FlashAnim
import kotlinx.android.synthetic.main.activity_main.*

class KotlinSampleActivity : AppCompatActivity() {

    private val TAG = "Flashbar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var flashbar: Flashbar? = null

        show.setOnClickListener {
            if (flashbar == null) {
                flashbar = basic()
            }
            flashbar?.show()
        }

        dismiss.setOnClickListener {
            flashbar?.dismiss()
        }
    }

    private fun basic(): Flashbar {
        return Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .enableSwipeToDismiss()
                .icon(R.drawable.email)
                .title("Review Security")
                .message("Someone tried to access your account")
                .duration(2000)
                .showIcon()
                //.showOverlay()
                //.titleColorRes(R.color.white)
                //.titleSizeInSp(28)
                //.titleTypeface(Typeface.createFromAsset(getAssets(), "BeautifulAndOpenHearted.ttf"))
                //.messageColor(ContextCompat.getColor(this, R.color.white))
                //.messageSizeInSp(24)
                //.messageTypeface(Typeface.createFromAsset(getAssets(), "BeautifulAndOpenHearted.ttf"))
                //.overlayColorRes(R.color.modal)
                .build()
    }

}