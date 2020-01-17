package com.cragon.mcw.manager

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandManager : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        /*if (sender is Player) {
            if (args[0].equals("skill", ignoreCase = true)) {
                if (args[1].equals("get", ignoreCase = true)) {
                    try {
                        when (args[2].toInt()) {
                            1 -> sender.inventory.addItem(SkillManager.skill1.skillItem)
                            2 -> {
                            }
                            else -> {
                            }
                        }
                    } catch (e: NumberFormatException) { // ERROR: it's not number
                    }
                } else if (args[1].equals("give", ignoreCase = true)) {
                }
            }
        }*/
        return true
    }
}