package game.utils

import game.utils.Profiler
import screeps.api.Game

class Logger(n : String)
{
	fun log(msg : String) : Unit =
		console.log("[${this.name}][${Game.time}] --> $msg")

	private val name : String = n
}
