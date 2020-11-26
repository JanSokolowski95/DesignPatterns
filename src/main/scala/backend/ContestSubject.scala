package backend

trait ContestSubject {
  def getName(): String = {
    this.getClass.getSimpleName
  }
}

case class Muzyczny() extends ContestSubject

case class Obrazkowy() extends ContestSubject