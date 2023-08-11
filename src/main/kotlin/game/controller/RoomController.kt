package game.controller

import game.memory.requiredCreeps
import game.memory.role_
import game.type.ERole
import game.type.Filter
import game.utils.Logger
import game.utils.Profiler

import screeps.api.*
import screeps.api.structures.StructureExtension
import screeps.api.structures.StructureSpawn
import screeps.utils.unsafe.jsObject


object RoomController
{
	fun loop(room : Room)
	{
		val profiler = Profiler("RoomController")
		profiler.start()

		val logger = Logger("RoomController")

		val creeps = room.find(FIND_MY_CREEPS)


		game.utils.executeTicks(10) {
			val harvesters = creeps.filter { it.memory.role_ == ERole.HARVESTER }
			val upgraders = creeps.filter { it.memory.role_ == ERole.UPGRADER }
			val builders = creeps.filter { it.memory.role_ == ERole.BUILD }
			val defenders = creeps.filter { it.memory.role_ == ERole.DEFENCE }
			val attackers = creeps.filter { it.memory.role_ == ERole.ATTACK }
			val healers = creeps.filter { it.memory.role_ == ERole.HEAL }


			logger.log("harvesters: ${harvesters.size}")
			logger.log("upgraders: ${upgraders.size}")
			logger.log("builders: ${builders.size}")
			logger.log("defenders: ${defenders.size}")
			logger.log("attackers: ${attackers.size}")
			logger.log("healers: ${healers.size}")

			val mem = room.memory

			if (harvesters.size < mem.requiredCreeps[ERole.HARVESTER]!!)
			{
				val newName = "Harvester${Game.time}"
				logger.log("Spawning new harvester: $newName")

				var arr = arrayOf(WORK, CARRY, MOVE)

				val spawn = findSpawn(room).first()

				spawn.spawnCreep(
					arrayOf(WORK, CARRY, MOVE),
					newName,
					options { memory = jsObject<CreepMemory> { role_ = ERole.HARVESTER } })
			}
			else if (upgraders.size < mem.requiredCreeps[ERole.UPGRADER]!!)
			{
				val newName = "Upgrader${Game.time}"
				logger.log("Spawning new upgrader: $newName")
				val spawn = findSpawn(room).first()
				spawn.spawnCreep(
					arrayOf(WORK, CARRY, MOVE),
					newName,
					options { memory = jsObject<CreepMemory> { role_ = ERole.UPGRADER } })
			}
			else if (builders.size < mem.requiredCreeps[ERole.BUILD]!!)
			{
				val newName = "Builder${Game.time}"
				logger.log("Spawning new builder: $newName")
				val spawn = findSpawn(room).first()
				spawn.spawnCreep(
					arrayOf(WORK, CARRY, MOVE),
					newName,
					options { memory = jsObject<CreepMemory> { role_ = ERole.BUILD } })
			}
		}

	}

	fun findEnergySources(room : Room, filter : Filter<Source> = { true }) : Array<Source>
	{
		return room.find(FIND_SOURCES).filter(filter).toTypedArray()
	}

	fun findSpawn(room : Room, filter : Filter<StructureSpawn> = { true }) : Array<StructureSpawn>
	{
		return room.find(FIND_MY_SPAWNS).filter(filter).toTypedArray()
	}

	fun findConstructionSites(room : Room, filter : Filter<ConstructionSite> = { true }) : Array<ConstructionSite>
	{
		return room.find(FIND_MY_CONSTRUCTION_SITES).filter(filter).toTypedArray()
	}

	fun findExtensions(room : Room, filter : Filter<StructureExtension> = { true }) : Array<StructureExtension>
	{
		return room.find(FIND_MY_STRUCTURES)
			.filter { it.structureType == STRUCTURE_EXTENSION }
			.toTypedArray().unsafeCast<Array<StructureExtension>>()
			.filter(filter).toTypedArray()
	}
}