package com.cragon.mcw.manager

import org.bukkit.Material
import org.bukkit.event.Event
import org.bukkit.inventory.ItemStack
import java.util.*

abstract class SkillBase {
    var skillName: String? = null
    var manual: List<String>? = null
    var skillItem: ItemStack? = null

    abstract fun execute(e: Event?, idx: Int)

    protected fun initSkill(skillName: String?, item: Material?, vararg manual: String?) {
        this.skillName = skillName
        this.manual = Arrays.asList<String>(*manual)
        skillItem = ItemStack(item!!)
        val im = skillItem!!.itemMeta!!
        im.lore = this.manual
        im.setDisplayName(skillName)
        skillItem!!.itemMeta = im
    }
}