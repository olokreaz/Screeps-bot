package game.utils

import screeps.api.*


/**
 * Calculates the total cost of each body part for a creep.
 *
 * Body part costs:
 *
 * - MOVE: 50 (Decreases fatigue by 2 points per tick.)
 * - WORK: 100 (Harvests 2 energy units from a source per tick etc.)
 * - CARRY: 50 (Can contain up to 50 resource units.)
 * - ATTACK: 80 (Attacks another creep/structure with 30 hits per tick in a short-ranged attack.)
 * - RANGED_ATTACK: 150 (Attacks another single creep/structure with 10 hits per tick etc.)
 * - HEAL: 250 (Heals self or another creep restoring 12 hits per tick in short range etc.)
 * - CLAIM: 600 (Claims a neutral room controller. A creep with this body part will have a reduced life time etc.)
 * - TOUGH: 10 (No effect, just additional hit points to the creep's body. Can be boosted to resist damage.)
 *
 * @param body Array of BodyPartConstants.
 * @return Total cost of all body parts.
 */
fun sumBody(body : Array<BodyPartConstant>) : Int =
	body.sumOf { BODYPART_COST[it]!! }


class Profiler
{
	private var startTime : Double = 0.0
	private var endTime : Double = 0.0
	private var name : String = ""

	constructor(s : String = "")
	{
		name = s
	}

	init
	{
		start()
	}

	fun start() : Profiler
	{
		startTime = Game.cpu.getUsed()
		return this
	}

	fun stop() : Profiler
	{
		endTime = Game.cpu.getUsed()
		return this
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

fun executeTicks(ticks : Int, action : () -> Unit)
{
	if (Game.time % ticks == 0)
	{
		action()
	}
}