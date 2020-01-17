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
import org.bukkit.event.entity.ExplosionPrimeEvent
import org.bukkit.event.player.PlayerInteractEvent

class Skill1 : SkillBase() {
    init {
        initSkill(ChatColor.YELLOW.toString() + "skill_1", Material.YELLOW_DYE,
                ChatColor.BLUE.toString() + "화염구를 날립니다.", ChatColor.BLUE.toString() + "우클릭시 발동합니다.")

        EventManager.onInteractHandler.add(EventData(this, 1))
        EventManager.onExplosionPrimeHandler.add(EventData(this, 2))
    }

    override fun execute(_e: Event?, idx: Int) {
        when(idx) {
            1 -> {
                val e = _e as PlayerInteractEvent
                val p = e.player
                if (p.inventory.itemInMainHand == skillItem) {

                    val l = p.location
                    val v = l.direction

                    val f: Fireball = p.world.spawnEntity(l, EntityType.FIREBALL) as Fireball
                    f.setGravity(false)
                    f.velocity = v
                    Bukkit.getScheduler().scheduleSyncDelayedTask(main, {
                        f.remove()
                    }, 20L * 10)
                }
            }
            2 -> {
                val e = _e as ExplosionPrimeEvent
                if (e.entity is Fireball) {
                    e.fire = false
                    e.isCancelled = true
                }
            }
        }
    }
}
