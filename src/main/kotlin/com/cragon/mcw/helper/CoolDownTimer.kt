package com.cragon.mcw.helper

import com.cragon.mcw.manager.SkillBase
import com.cragon.mcw.manager.TimerBase

public final class CoolDownTimer(val sb: SkillBase) : TimerBase() {
    override fun eventStartTimer() {
        sb.coolDownStart()
    }

    override fun eventRunningTimer(i: Int) {

    }

    override fun eventEndTimer() {
        sb.coolDownEnd()
    }

}