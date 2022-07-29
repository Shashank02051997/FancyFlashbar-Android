package com.shashank.platform.fancyflashbarlib.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.shashank.platform.fancyflashbarlib.R

internal class FbButton : androidx.appcompat.widget.AppCompatTextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        R.style.FbButtonStyle
    )

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}