package com.example.android.morsedoc.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.morsedoc.R
import java.util.*

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Timer().schedule(NextStepTask(), 1000)
    }

    private inner class NextStepTask : TimerTask() {
        override fun run() {
            findNavController().navigate(R.id.action_welcomeFragment_to_dummyMainFragment)
        }

    }


}