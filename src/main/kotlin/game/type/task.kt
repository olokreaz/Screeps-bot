package game.type.task

import game.type.task.TaskManager.push


class HarvestAction : IAction
{
	override val id : String = "Harvest"
	override fun execute()
	{
		print("Harvesting...\n")
	}
}

class BuildAction : IAction
{
	override val id : String = "Build"
	override fun execute()
	{
		print("Building...\n")
	}
}

object TaskManager
{
	private val actions = mutableMapOf<String, IAction>()

	fun push(action : IAction)
	{
		actions[action.id] = action
	}

	fun get(id : String) : IAction?
	{
		return actions[id]
	}

	fun executeTasks()
	{
		for ((_, action) in actions)
		{
			action.execute()
		}
	}
}

interface IAction
{
	val id : String
	fun execute()

	companion object
	{
		fun register(action : IAction)
		{
			push(action)
		}
	}
}