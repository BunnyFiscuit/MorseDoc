package com.example.android.morsedoc.views

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.android.morsedoc.R


private const val TAG = "UnlockFragment"
private const val GESTURE_TAG = "MyGestureListener"

class UnlockFragment : Fragment() {

    companion object {
        fun newInstance(): UnlockFragment {
            return UnlockFragment()
        }
    }

    private lateinit var navigationManager: Navigation

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
        view?.findViewById<ImageView>(R.id.lockIcon)
            ?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Log.d(TAG, "lockIcon onClick!")
                    findNavController().navigate(R.id.action_unlockFragment_to_inputFragment)
                }
            })
    }
}
