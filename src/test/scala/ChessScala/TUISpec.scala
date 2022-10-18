package ChessScala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import java.io.FileInputStream


class TUISpec extends AnyWordSpec with Matchers {

  val tui = new TUI
  var menuWrongInput: String = ""
  var menuCorrectInput: String = ""
  var gameWrongInput: String = ""
  var gameMove: String = ""
  var gameMoveWithSpace: String = ""
  val menuInterpreter: MenuInterpreter = new MenuInterpreter
  val gameInterpreter = new GameInterpreter

  "the function processInputLine should" should {
    "set the correct interpreter" in {
      tui.interpreter.isInstanceOf[MenuInterpreter] should be (true)
      menuWrongInput = tui.processInputLine("2")
      tui.interpreter.isInstanceOf[MenuInterpreter] should be (true)
      menuCorrectInput = tui.processInputLine("1")
      tui.interpreter.isInstanceOf[GameInterpreter] should be (true)
      gameWrongInput = tui.processInputLine("e2e9")
      gameMove = tui.processInputLine("e2e4")
      gameMoveWithSpace = tui.processInputLine("e2 e4")
      tui.interpreter.isInstanceOf[GameInterpreter] should be (true)
    }

    "return the correct String" in {
      menuWrongInput should be ("Wrong input. Please try again.")
      menuCorrectInput should be ("")
      gameWrongInput should be ("Wrong move. Please try again.")
      gameMove should be ("e2 moved to e4")
      gameMoveWithSpace should be ("e2 moved to e4")
    }
  }
}