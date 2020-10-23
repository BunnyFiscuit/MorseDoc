package com.example.android.morsedoc.model

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

object InputModel {
    private val TAG = "InputModel"

    private var attemptInput = ArrayList<MorsePress>()
    private var securedInput = ArrayList<MorsePress>()


    init {
        Log.d(TAG, "init")
        setTest(2)
    }


    fun resetAttempt() {
        attemptInput = arrayListOf()
    }

    // .-..
    private fun setSecuredTest1() {
        securedInput = arrayListOf();
        securedInput.addAll(listOf(
            MorsePress.SHORT,
            MorsePress.LONG,
            MorsePress.SHORT,
            MorsePress.SHORT,
        ));
    }

    // ..-.--
    private fun setSecuredTest2() {
        securedInput = arrayListOf();
        securedInput.addAll(listOf(
            MorsePress.SHORT,
            MorsePress.SHORT,
            MorsePress.LONG,
            MorsePress.SHORT,
            MorsePress.LONG,
            MorsePress.LONG,
        ));
    }

    // --...--..
    private fun setSecuredTest3() {
        securedInput = arrayListOf();
        securedInput.addAll(listOf(
            MorsePress.LONG,
            MorsePress.LONG,
            MorsePress.SHORT,
            MorsePress.SHORT,
            MorsePress.SHORT,
            MorsePress.LONG,
            MorsePress.LONG,
            MorsePress.SHORT,
            MorsePress.SHORT
        ));
    }

    fun setTest(test: Int) {
        when (test) {
            1 -> setSecuredTest1()
            2 -> setSecuredTest2()
            3 -> setSecuredTest3()
        }
    }

    fun correctAttempt(): Boolean {
        return attemptInput == securedInput
    }

    fun inputsEqual(): Boolean {
        return attemptInput.size == securedInput.size
    }

    fun attemptAdd(morsePress: MorsePress) {
        if (attemptInput.size < 9) {
            attemptInput.add(morsePress)
        }
    }

    fun removeLastInput() {
        attemptInput.removeLast()
    }

    fun getAttempts() : ArrayList<MorsePress> {
        return attemptInput
    }

    fun inputMax(): Int {
        return securedInput.size
    }


}