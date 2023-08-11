package game.type

import screeps.api.*
import screeps.utils.unsafe.jsObject
import screeps.utils.memory.memory


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

class Position
{
	override fun toString() : String
	{
		return "(x=$x, y=$y)"
	}

	constructor(x : Int, y : Int)
	{
		this.x = x
		this.y = y
	}

	constructor(pos : RoomPosition)
	{
		this.x = pos.x
		this.y = pos.y

	}

	var x : Int = 0
	var y : Int = 0
}

data class Task(
	val id : String = "",
	val target : Target? = null,
	val priority : Int = 5,
               )

class PriorityQueue
{
	private val taskList = mutableListOf<Task>()

	fun push(taskId : String, taskPriority : Int)
	{
		push(Task(taskId, priority = taskPriority))
	}

	private fun push(task : Task)
	{
		var i = taskList.size - 1
		while (i >= 0)
		{
			if (taskList[i].priority > task.priority)
			{
				break
			}
			i--
		}
		taskList.add(i + 1, task)
	}

	fun pushAll(tasks : List<Task>)
	{
		tasks.forEach { push(it) }
	}

	fun pop() : Task
	{
		return taskList.removeAt(0)
	}

	fun empty() =
		taskList.isEmpty()
}

data class Target(
	var pos : Position? = null,
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
