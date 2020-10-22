package com.example.android.morsedoc.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.example.android.morsedoc.R

class MyFolder(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var folderName: String



    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyFolder, 0,0).apply {
            try {
                folderName = getString(R.styleable.MyFolder_folderName).toString()
            } finally {
                recycle()
            }
        }
    }

    fun setFolderName(name: String){
        folderName = name
        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}