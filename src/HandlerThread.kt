import java.util.*
import java.util.concurrent.CountDownLatch

class HandlerThread : Thread("HandlerThread") {
    private lateinit var mLooper: Looper

    private val lock = CountDownLatch(1)

    fun getLooper(): Looper {
        lock.await()
        return mLooper
    }

    override fun run() {
        Looper.prepare()
        mLooper = Looper.myLooper()
       lock.countDown()
       Looper.loop()
    }
}
