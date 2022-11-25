package ChessScala.model.interpreter

import ChessScala.model.interpreter.{GameInterpreter, Interpreter}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameInterpreterSpec extends AnyWordSpec with Matchers {
  val interpreter = new GameInterpreter
  val didMove: (String, Boolean) = interpreter.processInputLine("e2e4")
  val didMoveUpper: (String, Boolean) = interpreter.processInputLine("E2E4")
  val didMoveWithSpace: (String, Boolean) = interpreter.processInputLine("e2 e4")
  val wrongMove: (String, Boolean) = interpreter.processInputLine("e2e9")

  "The Interpreter should" should {
    "have the right descriptor" in {
      interpreter.descriptor should be ("Please enter your Move")
    }
  }

  "The function processInputLine should" should {
    val result: String = "e2 moved to e4"
    val upperResult: String = "E2 moved to E4"
    val wrongInput: String = "Wrong move. Please try again."

    "return the correct string" in {
      didMove._1 should be (result)
      didMoveUpper._1 should be (upperResult)
      didMoveWithSpace._1 should be (result)
      wrongMove._1 should be (wrongInput)
    }

    "return the correct interpreter" in {
      didMove._2 should be (true)
      didMoveUpper._2 should be (true)
      didMoveWithSpace._2 should be (true)
      wrongMove._2 should be (false)
    }
  }

}