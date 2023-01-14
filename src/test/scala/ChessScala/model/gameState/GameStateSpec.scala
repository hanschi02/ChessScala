package ChessScala.model.gameState
import ChessScala.model.board.*
import ChessScala.model.figureStrategies.{Pawn, Team, White}
import ChessScala.model.gameState.stateImplementation.GameState
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameStateSpec extends AnyWordSpec with Matchers {

  val state: GameState = new GameState(White, (new BoardBuilder(8).createChessBoard()))

  "A MenuState " should {

    "return a gameState " in {

      var result = state.handle("e2e4")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("e2 moved to e4")
      var board = result._1.board
      board.get(Coordinate(4,1)) should be (None)
      board.get(Coordinate(4,3)).get.isInstanceOf[Pawn] should be (true)

      result = result._1.handle("e7e5")
      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("e7 moved to e5")
       board = result._1.board
      board.get(Coordinate(4,6)) should be (None)
      board.get(Coordinate(4,4)).get.isInstanceOf[Pawn] should be (true)

    }

    "return an error " in {

      var result = state.handle("1")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Wrong move. Please try again.")

      result = state.handle("e3e6")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Wrong move. Please try again.")

    }

  }

}
