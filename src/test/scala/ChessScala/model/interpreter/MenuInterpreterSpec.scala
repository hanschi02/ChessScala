package ChessScala.model.interpreter

import ChessScala.model.interpreter.interpreterImplementations.{GameInterpreter, MenuInterpreter}
import ChessScala.model.interpreter.Interpreter
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MenuInterpreterSpec extends AnyWordSpec with Matchers {
  val interpreter: Interpreter = new MenuInterpreter
  val newInterpreter: Boolean = interpreter.processInputLine("1")._2
  val wrongInput: (String, Boolean) = interpreter.processInputLine("something else")
  val wrongOutput: String = "Wrong input. Please try again."

  "The Interpreter should" should {
    "have the right descriptor" in {
      interpreter.descriptor should be("Please enter 1 for a new game")
    }
  }

  "the function processInputLine should" should {
    "return a GameInterpreter if input is 1" in {
      interpreter.processInputLine("1") should be ("", true)
    }

    "return an Error if input is wrong" in {
      wrongInput._1 should be (wrongOutput)
      wrongInput._2 should be (false)
    }
  }

}