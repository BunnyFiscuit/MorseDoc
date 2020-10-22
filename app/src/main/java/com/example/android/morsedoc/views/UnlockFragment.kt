package com.example.android.morsedoc.views

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.android.morsedoc.R
import com.example.android.morsedoc.model.InputModel

private const val TAG = "UnlockFragment"
private const val GESTURE_TAG = "MyGestureListener"

class UnlockFragment : Fragment() {


    private lateinit var navigationManager: Navigation
    private lateinit var inputModel: InputModel
    private lateinit var btnContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_unlock, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnContainer = view?.findViewById<LinearLayout>(R.id.test_btns_container)!!
        // Change visibility of buttons for testing purposes
        btnContainer.visibility = View.VISIBLE

        inputModel = InputModel

        view?.findViewById<ImageView>(R.id.lockIcon)
            ?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Log.d(TAG, "lockIcon onClick!")

                    findNavController().navigate(R.id.action_unlockFragment_to_inputFragment)
                }
            })

        view?.findViewById<Button>(R.id.test1btn)?.setOnClickListener {
            inputModel.setTest(1)
            toast("Test 1 set!")
        }
        view?.findViewById<Button>(R.id.test2btn)?.setOnClickListener {
            inputModel.setTest(2)
            toast("Test 2 set!")
        }
        view?.findViewById<Button>(R.id.test3btn)?.setOnClickListener {
            inputModel.setTest(3)
            toast("Test 3 set!")
        }
    }


    fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
