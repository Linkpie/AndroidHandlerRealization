fun main() {
    val handlerThread = HandlerThread()
    handlerThread.start()
    val handler = Handler(handlerThread.getLooper())

    handler.post(Runnable { println("Hello world ${Thread.currentThread()}") })
    while (true) {
        val a = readLine()?.toInt() ?: 0
        if(a % 2 == 0){
            handler.post(Runnable {
                Thread.sleep(2000)
                println("${Thread.currentThread()}")
            })
        }else{
            println("${Thread.currentThread()}")
        }
    }
}