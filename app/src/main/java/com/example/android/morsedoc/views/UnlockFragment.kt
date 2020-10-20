package com.example.android.morsedoc.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.android.morsedoc.R

class UnlockFragment : Fragment() {

    companion object {
        fun newInstance(): UnlockFragment {
            return UnlockFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_unlock,container,false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val fragmentLayout = getView()?.findViewById<ConstraintLayout>(R.id.fragment_unlock)

    }



}
