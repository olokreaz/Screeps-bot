package game.utils

import screeps.api.*

fun SumBody(body : Array<BodyPartConstant>) : Int =
	body.sumOf { BODYPART_COST[it]!! }


class Profiler
{
	private var startTime : Double = 0.0
	private var endTime : Double = 0.0

	init
	{
		start()
	}

	fun start()
	{
		startTime = Game.cpu.getUsed()
	}

	fun stop()
	{
		endTime = Game.cpu.getUsed()
	}

	private val elapsedTime : Double
		get() = endTime - startTime

	override fun toString() : String
	{
		if (endTime == 0.0)
			return (Game.cpu.getUsed() - startTime).toString()
		return this.elapsedTime.toString()
	}
}