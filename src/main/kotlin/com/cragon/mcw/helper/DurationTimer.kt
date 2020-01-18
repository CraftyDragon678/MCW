package com.cragon.mcw.helper

import com.cragon.mcw.manager.SkillBase
import com.cragon.mcw.manager.TimerBase

public final class DurationTimer(val sb: SkillBase, val ctimer: CoolDownTimer) : TimerBase() {
    override fun eventStartTimer() {
    }

    override fun eventRunningTimer(i: Int) {
    }

    override fun eventEndTimer() {
    }

}