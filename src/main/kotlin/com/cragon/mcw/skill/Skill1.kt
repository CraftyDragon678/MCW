package com.cragon.mcw.skill

import com.cragon.mcw.helper.EventData
import com.cragon.mcw.manager.EventManager
import com.cragon.mcw.manager.SkillBase
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Fireball
import org.bukkit.event.Event
import org.bukkit.event.player.PlayerInteractEvent

class Skill1 : SkillBase() {
    private val fireballList = ArrayList<Fireball>()
    init {
        initSkill(ChatColor.YELLOW.toString() + "skill_1", Material.YELLOW_DYE,
                "${ChatColor.BLUE}화염구를 날립니다.", "${ChatColor.BLUE}우클릭시 발동합니다.")

        EventManager.onInteractHandler.add(EventData(this, 1))
    }

    override fun execute(_e: Event?, idx: Int) {
        when(idx) {
            1 -> {
                val e = _e as PlayerInteractEvent
                val p = e.player
                if (p.inventory.itemInMainHand == skillItem) {

                    val l = p.eyeLocation
                    val v = l.direction

                    val f: Fireball = p.world.spawnEntity(l, EntityType.FIREBALL) as Fireball
                    f.setGravity(true)
                    f.velocity = v
                    f.setIsIncendiary(false)
                    f.yield = 0f
                    fireballList.add(f)
                    Bukkit.getScheduler().scheduleSyncDelayedTask(main, {
                        if (fireballList.contains(f)) {
                            f.remove()
                            fireballList.remove(f)
                        }
                    }, 20L * 10)
                }
            }
        }
    }
}
