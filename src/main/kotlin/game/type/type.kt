package game.type

import screeps.api.RoomPosition
import screeps.api.*


enum class ERole(vstr : String)
{
	HARVESTER("Harvester"),
	UPGRADER("Upgrader"),
	BUILD("builder"),
	DEFENCE("Defender"),
	ATTACK("Attacker"),
	HEAL("Healer"),
	NONE("undefined");
}

data class Target(
	var pos : RoomPosition? = null,
	var id : String? = null,
	var room : Room? = null,
	var type : StructureConstant? = null,
                 )
{
	override fun toString() : String
	{
		return "Target(pos=$pos, id=$id, room=$room, type=${type})"
	}
}
