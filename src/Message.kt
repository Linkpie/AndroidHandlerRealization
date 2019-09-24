class Message(val runnable: Runnable) {

    fun run() {
        runnable.run()
    }

}