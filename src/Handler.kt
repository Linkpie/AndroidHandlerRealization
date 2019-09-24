class Handler {
    var currentLooper: Looper

    constructor() {
        currentLooper = Looper.myLooper()
    }

    constructor(looper: Looper) {
        currentLooper = looper
    }

    fun post(runnable: Runnable) {
        currentLooper.queue.put(Message(runnable))
    }

}