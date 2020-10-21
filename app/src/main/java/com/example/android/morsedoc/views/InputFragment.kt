package com.example.android.morsedoc.views

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.morsedoc.R
import model.ImageFactory
import model.InputModel
import model.MorsePress
import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*
import kotlin.math.roundToInt

private const val TAG: String = "InputFragment"

class InputFragment: Fragment() {

    companion object {
        fun newInstance(): InputFragment {
            return InputFragment()
        }
    }


    private lateinit var tableLayout: TableLayout
    private lateinit var inputView: View
    private lateinit var inputModel: InputModel
    private lateinit var progressBar: ProgressBar
    private lateinit var imageFactory: ImageFactory
    private lateinit var visibilityView: ImageView
    private var inputVisible = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        inputModel = model.InputModel
        imageFactory = context?.let { ImageFactory(it) }!!

        inputView = view?.findViewById(R.id.input_view)!!
        tableLayout = view?.findViewById(R.id.tableLayout)!!

        initListeners()
        initProgressBar()

        view?.findViewById<ImageView>(R.id.xbutton)?.setOnClickListener { reset() }

        view?.findViewById<ImageView>(R.id.input_visiblity)?.setOnClickListener { view: View? ->
            val iv: ImageView = view as? ImageView ?: return@setOnClickListener
            if (inputVisible) iv.setImageResource(R.drawable.ic_visibility_off)
            else iv.setImageResource(R.drawable.ic_visibility)

            inputVisible = !inputVisible
            update()
        }
    }

    private fun initListeners() {
        inputView.setOnTouchListener(MyClickListener(this))
    }

    private fun initProgressBar() {
        Log.d(TAG, "initProgressBar. max: ${inputModel.inputMax()}")
        progressBar = view?.findViewById(R.id.inputProgress)!!
        progressBar.max = inputModel.inputMax()
        progressBar.progress = 0
    }

    private fun update() {
        Log.d(TAG, "update")

        tableLayout.removeAllViews()
        progressBar.progress = inputModel.getAttempts().size

        // Hide inputs
        if (!inputVisible) return

        val attempts = inputModel.getAttempts()
        if (attempts.size == 0) return

        Log.d(TAG, "inputModel.getAttempts().size: $attempts.size")
        val rows = max(Math.floorDiv(attempts.size, 3),3) - 1
        Log.d(TAG, "rows: $rows")


        var mCounter = 0
        for (row in 0..rows) {
            val tr = TableRow(context)

            tr.id = 100 + row
            val trParams = TableLayout.LayoutParams(MATCH_CONSTRAINT,
                resources.getDimension(R.dimen.table_row_height).roundToInt())

            attempts.forEachIndexed { index, morsePress ->
                if (index >= mCounter && index < mCounter+3) {
                    val image = imageFactory.getImage(morsePress)
                    tr.addView(image, image.layoutParams)
                }
            }

            tr.layoutParams = trParams
            tableLayout.addView(tr, trParams)
            mCounter += 3
        }
        tableLayout.isStretchAllColumns = true
        if (inputModel.inputsEqual() && inputModel.correctAttempt()) {
            Timer().schedule(InputCheckTask(), 500)
        }
    }


    private inner class InputCheckTask() : TimerTask() {
        override fun run() {
            findNavController().navigate(R.id.action_inputFragment_to_welcomeFragment)
        }

    }

    private fun reset() {
        Log.d(TAG, "reset()")
        inputModel.resetAttempt()
        tableLayout.removeAllViews()
        update()
    }

    override fun onPause() {
        super.onPause()
        reset()
    }


    private open class MyClickListener(val fragment: InputFragment?) : View.OnTouchListener {

        private val TAG: String = "MyClickListener"

        private var lastDown: Long = 0
        private var lastDuration: Long = 0
        private var inputModel = model.InputModel

        override fun onTouch(v: View?, e: MotionEvent?): Boolean {
            if (!inputModel.inputsEqual()) {
                if (e?.action == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis()
                } else if (e?.action == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown
                    if (lastDuration >= 200) {
                        Log.d(TAG, "Long Press!")
                        inputModel.attemptAdd(MorsePress.LONG)
                    } else {
                        Log.d(TAG, "Short Press!")
                        inputModel.attemptAdd(MorsePress.SHORT)
                    }
                    v?.performClick()
                    fragment?.update()
                }
            }
            return true
        }
    }

}
