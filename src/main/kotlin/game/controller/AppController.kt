package game.controller

import screeps.api.*
import screeps.utils.unsafe.delete

import game.utils.Profiler


object AppController
{
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
				val timer : Profiler = Profiler()
				delete(Memory.creeps[creepName])

			}
		}
	}

}