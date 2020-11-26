package backend

class Participant(name: String, goodAnswerOwnQuestionPoints: Int, goodAnswerElseQuestionPoints: Int, badAnswerElseQuestionPoints: Int) {
  var score = 0
  var isYourTurn = false

  def Answer(isCorrect: Boolean): Unit = {
    if (isCorrect) {
      CorrectAnswer()
    } else IncorrectAnswer()
  }

  private def CorrectAnswer(): Unit = {
    if (isYourTurn) {
      ChangeScore(goodAnswerOwnQuestionPoints)
    } else ChangeScore(goodAnswerElseQuestionPoints)
  }

  private def IncorrectAnswer(): Unit = {
    if (!isYourTurn) {
      ChangeScore(badAnswerElseQuestionPoints)
    }
  }

  private def ChangeScore(points: Int): Unit = {
    score += points
  }

  def StartTurn(): Unit = {
    isYourTurn = true
  }

  def EndTurn(): Unit = {
    isYourTurn = false
  }

  def getScore(): Int = {
    score
  }

}

class Team(name: String, members: List[Participant], goodAnswerOwnQuestionPoints: Int = 2, goodAnswerElseQuestionPoints: Int = 1, badAnswerElseQuestionPoints: Int = -2)
  extends Participant(name: String, goodAnswerOwnQuestionPoints: Int, goodAnswerElseQuestionPoints: Int, badAnswerElseQuestionPoints: Int)

