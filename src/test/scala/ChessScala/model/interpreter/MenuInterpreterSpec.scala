package ChessScala.model.interpreter

import ChessScala.model.interpreter.{GameInterpreter, Interpreter, MenuInterpreter}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MenuInterpreterSpec extends AnyWordSpec with Matchers {
  val interpreter: Interpreter = new MenuInterpreter
  val newInterpreter: Interpreter = interpreter.processInputLine("1")._2
  val wrongInput: (String, Interpreter) = interpreter.processInputLine("something else")
  val isGameInterpreter: Boolean = newInterpreter.isInstanceOf[GameInterpreter]
  val wrongOutput: String = "Wrong input. Please try again."

  "The Interpreter should" should {
    "have the right descriptor" in {
      interpreter.descriptor should be("Please enter 1 for a new game")
    }
  }

  "the function processInputLine should" should {
    "return a GameInterpreter if input is 1" in {
      isGameInterpreter should be (true)
    }

    "return an Error if input is wrong" in {
      wrongInput._1 should be (wrongOutput)
      wrongInput._2 should be (interpreter)
    }
  }

}