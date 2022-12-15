package ChessScala.model.gameState
import ChessScala.model.board.*
import ChessScala.model.figureStrategies.{Team, White}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameStateSpec extends AnyWordSpec with Matchers {

  val state: GameState = new GameState(White, (new BoardBuilder(8).createChessBoard()))

  "A MenuState " should {

    "return a gameState " in {

      val result = state.handle("e2e4")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("e2 moved to e4")

    }
/*
    "return an error " in {

      val result = state.handle("1")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Wrong input. Please try again.")

    }*/

  }

}
