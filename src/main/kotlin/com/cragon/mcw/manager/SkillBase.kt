package com.cragon.mcw.manager

import com.cragon.mcw.MCW
import org.bukkit.Material
import org.bukkit.event.Event
import org.bukkit.inventory.ItemStack

abstract class SkillBase {

    var skillName: String? = null
    var manual: List<String>? = null
    var skillItem: ItemStack? = null

    abstract fun execute(_e: Event?, idx: Int)

    public fun coolDownStart() {}
    public fun coolDownEnd() {}
    public fun durationStart() {}
    public fun durationEnd() {}
    public fun finalDurationEnd() {}

    protected fun initSkill(skillName: String, item: Material, vararg manual: String) {
        this.skillName = skillName
        this.manual = manual.asList()
        skillItem = ItemStack(item)
        val im = skillItem!!.itemMeta!!
        im.lore = this.manual
        im.setDisplayName(skillName)
        skillItem!!.itemMeta = im
    }

    companion object {
        lateinit var main: MCW

        fun initSkillBase(main: MCW) {
            SkillBase.main = main
        }

    }
}