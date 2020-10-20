package model

object InputModelSingleton {
    val instance = InputModel()
}

class InputModel constructor() {


    companion object {
        val instance = InputModel()
    }

    private var attemptInput = ArrayList<MorsePress>()
    private var securedInput = ArrayList<MorsePress>()

    fun resetAttempt() {
        attemptInput = ArrayList<MorsePress>()
    }

    fun setSecuredTest() {
        securedInput.add(MorsePress.SHORT)
        securedInput.add(MorsePress.LONG)
        securedInput.add(MorsePress.SHORT)
        securedInput.add(MorsePress.LONG)
        securedInput.add(MorsePress.SHORT)
        securedInput.add(MorsePress.LONG)
        securedInput.add(MorsePress.SHORT)
        securedInput.add(MorsePress.LONG)
        securedInput.add(MorsePress.SHORT)
    }

    fun checkAttempt(): Boolean {
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