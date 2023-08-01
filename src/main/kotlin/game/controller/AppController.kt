package game.controller

import screeps.api.*
import screeps.utils.unsafe.delete

import game.utils.Profiler
import game.utils.Logger


object AppController
{
	fun loop()
	{

		val profiler = Profiler()
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