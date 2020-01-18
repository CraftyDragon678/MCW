package com.cragon.mcw.manager

import java.util.*
import java.util.TimerTask as TimerTask

abstract class TimerBase {
    public var count: Int = 0
    private var inf: Boolean = false
    private var maxCount: Int = 0
    private var reverse: Boolean = false
    private var running: Boolean = false
    private var timer: Timer? = null

    private final inner class CustomTimerTask : TimerTask {
        private constructor()
        constructor(timerBase: TimerBase?, customTimerTask: CustomTimerTask?) {
            CustomTimerTask()
        }

        override fun run() {
            eventRunningTimer(count)
            if (inf) return
            if (reverse) {
                if (count <= 0) {
                    endTimer()
                    return
                }
                count -= 1
            } else if (count >= maxCount) {
                endTimer()
            } else {
                count += 1
            }
        }

    }

    public abstract fun eventStartTimer()
    public abstract fun eventRunningTimer(i: Int)
    public abstract fun eventEndTimer()
    public fun finalEventEndTimer() {}

    public final fun setTimerData(maxCount_: Int, reverse_: Boolean) {
        maxCount = maxCount_
        reverse = reverse_
    }
    public final fun startTimer(maxCount_: Int, reverse_: Boolean = false, period: Int = 1000) {
        this.timer = Timer()
        this.timer!!.schedule(CustomTimerTask(this, null), 0, period as Long)
    }
    public final fun endTimer() {
        stopTimer()
        eventEndTimer()
    }
    public final fun stopTimer() {
        this.timer?.cancel()
        this.count = 0
        this.running = false
        finalEventEndTimer()
    }
}