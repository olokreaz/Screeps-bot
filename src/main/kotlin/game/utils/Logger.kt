package game.utils

import screeps.api.Game

class Logger(NameClass : String)
{
	fun log(msg : String) =
		console.log("[${this.name}][${Game.time}] --> $msg")

	fun log(msg : String, profiler : Profiler) =
		console.log("[${this.name}][${Game.time}][%$profiler] --> $msg")

	fun log(NameFunction : String, msg : String) =
		console.log("[${this.name}][$NameFunction][${Game.time}] --> $msg")

	fun log(NameFunction : String, msg : String, profiler : Profiler) =
		console.log("[${this.name}][$NameFunction][${Game.time}][%$profiler] --> $msg")

	private val name : String = NameClass
}
