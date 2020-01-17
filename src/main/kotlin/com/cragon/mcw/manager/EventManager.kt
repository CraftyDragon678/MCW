package com.cragon.mcw.manager

import com.cragon.mcw.helper.EventData
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import java.util.*
import java.util.function.Consumer

class EventManager : Listener {
    fun eventExecuter(ed: ArrayList<EventData>, e: Event?) {
        ed.forEach(Consumer { handler: EventData -> handler.sb.execute(e, handler.idx) })
    }

    companion object {
        var onInteractHandler = ArrayList<EventData>()
        @EventHandler
        private fun onInteract(e: PlayerInteractEvent) {
            onInteractHandler.forEach(Consumer { handler: EventData? -> })
        }
    }
}