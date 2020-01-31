package com.cragon.mcw.manager

import com.cragon.mcw.helper.EventData
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityChangeBlockEvent
import org.bukkit.event.entity.EntityCombustByBlockEvent
import org.bukkit.event.entity.ExplosionPrimeEvent
import org.bukkit.event.player.PlayerInteractEvent
import java.util.*
import java.util.function.Consumer

class EventManager : Listener {
    companion object {
        var onInteractHandler = ArrayList<EventData>()
        var onExplosionPrimeHandler = ArrayList<EventData>()
        var onFallingBlockChangeHandler = ArrayList<EventData>()
    }

    @EventHandler
    private fun onInteract(e: PlayerInteractEvent) {
        eventExecutor(onInteractHandler, e)
    }

    @EventHandler
    private fun onExplosionPrime(e: ExplosionPrimeEvent) {
        eventExecutor(onExplosionPrimeHandler, e)
    }

    @EventHandler
    private fun onFallingBlockChange(e: EntityChangeBlockEvent) {
        eventExecutor(onFallingBlockChangeHandler, e)
    }

    private fun eventExecutor(ed: ArrayList<EventData>, e: Event?) {
        ed.forEach { it.sb.execute(e, it.idx) }
    }
}
