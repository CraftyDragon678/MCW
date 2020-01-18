package com.cragon.mcw.helper

import com.cragon.mcw.manager.SkillBase
import com.cragon.mcw.manager.TimerBase

public final class DurationTimer(val sb: SkillBase, val ctimer: CoolDownTimer) : TimerBase() {
    override fun eventStartTimer() {
        sb.durationStart()
    }

    override fun eventRunningTimer(i: Int) {
    }

    override fun eventEndTimer() {
        sb.durationEnd()
        ctimer.startTimer(sb.coolTime, false)
    }

    override fun finalEventEndTimer() {
        sb.finalDurationEnd()
    }
}