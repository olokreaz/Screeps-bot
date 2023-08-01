import game.controller.AppController
import game.*


@Suppress("unused")
fun loop()
{
	try
	{
		AppController.loop()
	}
	catch (e : Exception)
	{
		screeps.api.Game.notify("Error in loop: ${e.message}\n\tStuctrace:\n${e.stackTraceToString()}")
	}
}
