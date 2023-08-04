package game.controller

import game.*
import game.controller.RoomController.findEnergySources
import game.memory.requiredCreeps
import game.memory.role_
import screeps.api.*
import screeps.utils.unsafe.delete

import game.utils.Profiler
import game.utils.Logger

import screeps.api.structures.StructureController
import screeps.api.structures.StructureSpawn

import game.type.ERole
import screeps.utils.unsafe.jsObject

fun Creep.doHarvest()
{
	if (memory.role_ != ERole.HARVESTER) return

	if (store[RESOURCE_ENERGY] < this.store.getCapacity())
	{
		val source = findEnergySources(room).minByOrNull { pos.getRangeTo(it) }
		if (source != null && harvest(source) == ERR_NOT_IN_RANGE)
		{
			moveTo(source)
		}
	}
	else
	{
		val spawn = room.find(FIND_MY_SPAWNS).first()
		if (transfer(spawn, RESOURCE_ENERGY) == ERR_NOT_IN_RANGE)
		{
			moveTo(spawn)
		}
	}
}

fun Creep.doUpgrade()
{
	if (memory.role_ != ERole.UPGRADER) return

	val controller : StructureController = room.controller
	                                       ?: return

	if (store[RESOURCE_ENERGY] == 0)
	{
		val source = findEnergySources(room).minByOrNull { pos.getRangeTo(it) }
		if (source != null && harvest(source) == ERR_NOT_IN_RANGE)
		{
			moveTo(source)
		}
	}
	else
	{
		if (upgradeController(controller) == ERR_NOT_IN_RANGE)
		{
			moveTo(controller)
		}
	}
}

object AppController
{
	init
	{
		Logger().log("Start AI Executor;")
	}

	fun loop()
	{
		clearDeadCreepsMemory()
	}


	private fun clearDeadCreepsMemory()
	{
		for (creepName in Memory.creeps.keys)
		{
			if (Game.creeps[creepName] == null)
			{
				delete(Memory.creeps[creepName])
				logger.log("clearDeadCreepsMemory", "Delete $creepName;")
			}
		}
	}

	val logger : Logger = Logger("Global")
}