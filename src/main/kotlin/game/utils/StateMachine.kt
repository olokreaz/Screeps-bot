package game.utils

class StateMachine<T>
{
	private var currentState : T? = null
	private var nextState : T? = null

	constructor(state : T)
	{
		this.currentState = state
	}

	fun update(
		nextState : T?,
		pred : (cState : T, nState : T) -> Boolean =
			{ cState, nState -> cState == nState },
		action : (state : T) -> Unit = { },
	          ) : T?
	{
		if (this.currentState == null)
			this.currentState = nextState


		if (pred(this.currentState!!, nextState!!))
		{
			this.currentState = nextState
			action(this.currentState!!)
		}
		return this.currentState
	}
}
