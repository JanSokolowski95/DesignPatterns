package backend

trait ContestType

case class SingleParticipant() extends ContestType

case class Group() extends ContestType