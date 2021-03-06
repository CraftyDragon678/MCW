package com.cragon.mcw.skill

import com.cragon.mcw.helper.EventData
import com.cragon.mcw.manager.EventManager
import com.cragon.mcw.manager.SkillBase
import org.bukkit.*
import org.bukkit.entity.*
import org.bukkit.event.Event
import org.bukkit.event.entity.EntityChangeBlockEvent
import org.bukkit.event.entity.ExplosionPrimeEvent
import org.bukkit.event.player.PlayerInteractEvent

class Skill2 : SkillBase() {
    private val fallingBlockList = HashMap<FallingBlock, Player>()
    init {
        initSkill(ChatColor.YELLOW.toString() + "skill_2", Material.YELLOW_DYE,
                "${ChatColor.BLUE}블럭을 날립니다.", "${ChatColor.BLUE}우클릭시 발동합니다.")

        EventManager.onInteractHandler.add(EventData(this, 1))
        EventManager.onFallingBlockChangeHandler.add(EventData(this, 2))
        EventManager.tickHandler.add(EventData(this, 3))
    }

    override fun execute(_e: Event?, idx: Int) {
        when(idx) {
            1 -> {
                val e = _e as PlayerInteractEvent
                val p = e.player
                if (p.inventory.itemInMainHand == skillItem) {

                    val l = p.eyeLocation
                    val v = l.direction

                    val b = p.world.spawnFallingBlock(l, Material.STONE.createBlockData())
                    b.setGravity(true)
                    b.velocity = v
                    b.dropItem = false
                    b.setHurtEntities(true)
                    fallingBlockList[b] = p
                    Bukkit.getScheduler().scheduleSyncDelayedTask(main, {
                        b.remove()
                    }, 20L * 10)
                }
            }
            2 -> {
                val e = _e as EntityChangeBlockEvent
                if (fallingBlockList.contains(e.entity)) {
                    e.isCancelled = true
                    fallingBlockList.remove(e.entity)
                    e.entity.remove()
                }
            }
            3 -> {
                fallingBlockList.forEach { (t, u) ->
                    t.world.getNearbyEntities(t.location, 1.5, 1.5, 1.5).let {
                        it.forEach { entity ->
                            if (entity !is FallingBlock && entity != u && entity is LivingEntity) {
                                u.playSound(u.location, Sound.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f, 1f)
                                fallingBlockList.remove(t)
                                t.remove()
                                entity.damage(3.0)
                                return@let
                            }
                        }

                    }
                }
            }
        }
    }
}