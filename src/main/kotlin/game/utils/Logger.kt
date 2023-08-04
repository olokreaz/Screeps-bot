package game.utils

import screeps.api.Game

class Logger(NameClass : String = "Global")
{
	fun log(msg : String) =
		console.log("[${this.name}][${Game.time}] --> $msg")

	fun log(NameFunction : String, msg : String) =
		console.log("[${this.name}][$NameFunction][${Game.time}] --> $msg")

	private val name : String = NameClass
}
