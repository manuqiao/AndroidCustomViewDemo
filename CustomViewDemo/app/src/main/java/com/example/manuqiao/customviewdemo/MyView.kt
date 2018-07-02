package com.example.manuqiao.customviewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * Created by manuqiao on 2018/7/2.
 */
//class MyView@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
//        : View(context, attrs, defStyle) {
class MyView : View {
    var mPaint = Paint()
    val mString = "Welcome"
    val mContext: Context

    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : super(context, attrs, defStyle) {
        mContext = context

        val a = context.obtainStyledAttributes(attrs, R.styleable.MyView)
        val textColor = a.getColor(R.styleable.MyView_textColor, 0XFFFFFF)
        val textSize = a.getDimension(R.styleable.MyView_textSize, 36.0f)

        mPaint.textSize = textSize
        mPaint.color = textColor

        a.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.color = Color.RED
        mPaint.style = Paint.Style.FILL

        canvas!!.drawRect(Rect(10, 10, 100, 100), mPaint)
        mPaint.color = Color.BLUE
        canvas.drawText(mString, 10.0f, 110.0f, mPaint)
    }

}