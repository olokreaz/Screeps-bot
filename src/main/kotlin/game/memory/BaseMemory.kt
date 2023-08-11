package game.memory

import screeps.utils.memory.memory
import screeps.api.*
import game.type.ERole
import game.type.Target
import game.type.Task
import screeps.utils.lazyPerTick

// [Creep]


/** ObjectID /  */

var CreepMemory.role_ : ERole by memory { ERole.NONE }

// [Room]
var RoomMemory.requiredCreeps : MutableMap<ERole, Int> by memory { mutableMapOf() }
var RoomMemory.spawnQueue : MutableList<ERole> by memory { mutableListOf() }

// [Global]
var GlobalMemory.emergency : Boolean by memory { false }


// [Structure]