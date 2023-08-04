package game.controller

import game.utils.Logger
import game.utils.Profiler
import game.type.Filter

import screeps.api.*


object RoomController
{
	fun loop(room : Room)
	{

	}

	fun findEnergySources(room : Room, filter : Filter<Source> = { true }) : Array<Source>
	{
		return room.find(FIND_SOURCES).filter(filter).toTypedArray()
	}


}