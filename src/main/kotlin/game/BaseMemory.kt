package game

import screeps.utils.memory.memory
import screeps.api.*
import game.type.ERole

// [Creep]
var CreepMemory.targetID_ : String by memory { "" }
var CreepMemory.role : ERole by memory { ERole.NONE }
var CreepMemory.targetRoom : String by memory { "" }