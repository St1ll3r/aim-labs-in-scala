package my.scalafx

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Circle
import javafx.event.EventHandler
import util.Random

object ScalaFXHelloWorld extends JFXApp3 {

  var lastPos: Int = 0
  val WIDTH: Int = 1024
  val HEIGHT: Int = 768
  val firstNumber: Int = 25
  val secondNumber: Int = 1000


  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "Aim Labs In Scala"
      width = WIDTH
      height = HEIGHT
      scene = new Scene {
        fill = DarkGray
        content = {
          new Circle {
            centerX = 25
            centerY = 25
            fill = Red
            radius = 25
            centerX <== when(hover) choose { generateRandomInt() } otherwise 25
            centerY <== when(hover) choose { generateRandomInt() } otherwise 25
          }
        }
      }
    }
  }

  def generateRandomInt(): Int = {
    firstNumber + Random.nextInt((secondNumber - firstNumber) + 1 )
  }
}
