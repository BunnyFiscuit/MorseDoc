package model

import android.content.Context
import android.widget.ImageView
import android.widget.TableRow
import com.example.android.morsedoc.R
import kotlin.math.roundToInt

class ImageFactory(ctx: Context) {
    private val context = ctx


    fun getImage(morsePress: MorsePress): ImageView {
        return when (morsePress) {
            MorsePress.LONG -> getLongImage()
            MorsePress.SHORT -> getShortImage()
        }
    }

    private fun getLongImage() : ImageView {
        val image = ImageView(context)
        image.setImageResource(R.drawable.morse_long)
        image.layoutParams = TableRow.LayoutParams()
        image.layoutParams.width = context.resources.getDimension(R.dimen.morse_width).roundToInt()
        image.layoutParams.height = context.resources.getDimension(R.dimen.morse_height).roundToInt()
        return image
    }

    private fun getShortImage() : ImageView {
        val image = ImageView(context)
        image.setImageResource(R.drawable.morse_short)
        image.layoutParams = TableRow.LayoutParams()
        image.layoutParams.width = context.resources.getDimension(R.dimen.morse_width).roundToInt()
        image.layoutParams.height = context.resources.getDimension(R.dimen.morse_height).roundToInt()
        return image
    }

    fun getAltLongImage() : ImageView {
        val image = ImageView(context)
        image.setImageResource(R.drawable.morse_long_2)
        image.layoutParams = TableRow.LayoutParams()
        image.layoutParams.width = context.resources.getDimension(R.dimen.morse_width_2).roundToInt()
        image.layoutParams.height = context.resources.getDimension(R.dimen.morse_height).roundToInt()
        image.scaleType = ImageView.ScaleType.CENTER
        return image
    }

    fun getAltShortImage(): ImageView {
        val image = ImageView(context)
        image.setImageResource(R.drawable.morse_short_2)
        image.layoutParams = TableRow.LayoutParams()
        image.layoutParams.width = context.resources.getDimension(R.dimen.morse_width).roundToInt()
        image.layoutParams.height = context.resources.getDimension(R.dimen.morse_height).roundToInt()
        image.scaleType = ImageView.ScaleType.CENTER
        return image
    }

}