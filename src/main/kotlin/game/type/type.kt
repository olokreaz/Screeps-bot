package game.type


enum class ERole(vstr : String)
{
	HARVEST("Harvester"),
	BUILD("builder"),
	DEFENCE("Defender"),
	ATTACK("Attacker"),
	HEAL("Healer"),
	NONE("undefined");
}

enum class ETask // [ Creep ]
{
	Harvest,
	Build,
	Upgrade,
	Attack,
}