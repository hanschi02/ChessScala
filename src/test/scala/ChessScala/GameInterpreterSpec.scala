package ChessScala
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GameInterpreterSpec extends AnyWordSpec with Matchers {
  val interpreter = new GameInterpreter
  val didMove: (String, Interpreter) = interpreter.processInputLine("e2e4")
  val didMoveUpper: (String, Interpreter) = interpreter.processInputLine("E2E4")
  val didMoveWithSpace: (String, Interpreter) = interpreter.processInputLine("e2 e4")
  val wrongMove: (String, Interpreter) = interpreter.processInputLine("e2e9")

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
      didMove._2 should be (interpreter)
      didMoveUpper._2 should be (interpreter)
      didMoveWithSpace._2 should be (interpreter)
      wrongMove._2 should be (interpreter)
    }
  }

}