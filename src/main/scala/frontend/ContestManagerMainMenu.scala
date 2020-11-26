package frontend

import backend.{ContestSubject, Muzyczny, Obrazkowy}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.scene.paint.Color._

object ContestManagerMainMenu extends JFXApp {
  stage = new PrimaryStage {
    title = "Contest Manager"
    scene = new Scene {
      val button1 = CreateMainMenuButton(Obrazkowy())
      val button2 = CreateMainMenuButton(Muzyczny())
      val hbButtons = new HBox()
      hbButtons.setSpacing(10.0)
      hbButtons.getChildren().addAll(button1, button2)
      hbButtons.setAlignment(Pos.Center)
      content = new VBox(
        new Text {
          text = "Jaki rodzaj konkursu będziesz prowadzić?"
          style = "-fx-font-size: 24pt"
        },
        hbButtons
      )
    }
  }

  private def CreateMainMenuButton(contestType: ContestSubject): Button = {
    val button = new Button(contestType.getName())
    button.setStyle("-fx-font-size: 20pt")
    button
  }
}