package ChessScala.model.gameState
import ChessScala.model.board.Board
import ChessScala.model.gameState
import ChessScala.model.gameState.stateImplementation.{GameState, MateState}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MateStateSpec extends AnyWordSpec with Matchers {

  val mateState : MateState = new MateState("Stalemate, draw!",new Board(null))

  "A MenuState " should {

    "return a new game " in {

      val result = mateState.handle("1")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("")

    }

    "return an error " in {

      val result = mateState.handle("queen")

      result._1.isInstanceOf[GameState] should be(false)
      result._2 should be("Wrong input. Please try again.")

    }

  }

}
