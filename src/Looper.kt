import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class Looper {

    val queue = LinkedBlockingQueue<Message>()

    companion object {
        val loopers = ThreadLocal<Looper>()
        fun prepare() {
            val looper = Looper()
            loopers.set(looper)
        }

        fun myLooper(): Looper {
            return Looper.loopers.get()
        }

        fun loop() {
            val looper = Looper.myLooper()
            while (true) {
                looper.queue.poll()?.run()
            }
        }
    }


}