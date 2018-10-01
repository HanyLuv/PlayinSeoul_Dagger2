package com.work.hany.playinseoul.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * Global executor pools for the whole application.
 * <p>
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind webservice requests).
 */


@Singleton
class AppExecutors constructor(private val diskIO: Executor,
                               private val networkIO: Executor,
                               private val mainThread: Executor) {

    private val THREAD_COUNT = 3

    fun diskIO(): Executor {
        return diskIO
    }

    fun networkIO(): Executor {
        return networkIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}