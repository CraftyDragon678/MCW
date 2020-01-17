package com.cragon.mcw.skill

import com.cragon.mcw.manager.SkillBase
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.Event

class Skill1 : SkillBase() {
    override fun execute(e: Event?, idx: Int) {}

    init {
        initSkill(ChatColor.YELLOW.toString() + "skill_1", Material.YELLOW_DYE,
                ChatColor.BLUE.toString() + "화염구를 날립니다.", ChatColor.BLUE.toString() + "우클릭시 발동합니다.")
    }
}