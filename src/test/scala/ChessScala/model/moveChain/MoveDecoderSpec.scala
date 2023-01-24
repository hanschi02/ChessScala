package ChessScala.model.moveChain

import ChessScala.model.interpreter.Interpreter
import ChessScala.model.interpreter.interpreterImplementations.GameInterpreter
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MoveDecoderSpec extends AnyWordSpec with Matchers {
  val interpreter = new GameInterpreter
  val didMove: (String, Boolean) = interpreter.processInputLine("e2e4")
  val didMoveUpper: (String, Boolean) = interpreter.processInputLine("E2E4")
  val didMoveWithSpace: (String, Boolean) = interpreter.processInputLine("e2 e4")
  val wrongMove: (String, Boolean) = interpreter.processInputLine("e2e9")

  "The decoder should" should {
    "return a move" in {
      val result = MoveDecoder.decode("e2e4")
      result.start.x should be (4)
      result.start.y should be (1)
      result.target.x should be (4)
      result.target.y should be (3)
    }
  }
}