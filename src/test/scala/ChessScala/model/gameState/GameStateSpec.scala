package ChessScala.model.gameState
import ChessScala.model.board.*
import ChessScala.model.figureStrategies.{Pawn, Team, White}
import ChessScala.model.gameState.stateImplementation.{GameState, MateState}
import ChessScala.model.moveChain.{Move, MoveHandler}
import ChessScala.model.fileIO.fileIOJson.FileIO
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameStateSpec extends AnyWordSpec with Matchers {

  val state: GameState = new GameState(White, (new BoardBuilder(8).createChessBoard()))

  "A Gamestate " should {

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

      result = state.handle(("e2e8"))
      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Wrong move. Please try again.")

    }

    "save and load a game" in {
      val board = (new BoardBuilder(8)).createChessBoard()
      var state = new GameState(White, board)
      state = state.handle("e2e4")._1.asInstanceOf[GameState]
      state.handle("save")
      state = state.handle("load")._1.asInstanceOf[GameState]
      state.board.get(Coordinate(4,3)).isDefined should be (true)
      state = state.handle("e7e5")._1.asInstanceOf[GameState]
      state.handle("save")
      state = state.handle("load")._1.asInstanceOf[GameState]
      state.board.get(Coordinate(4,4)).isDefined should be (true)
    }

    "change to MateState" in {
      val fileIO = new FileIO
      val state: GameState = fileIO.load("testfiles/WhiteIsMateTest").asInstanceOf[GameState]
      val endState: ProgrammState = state.handle("d8h4")._1
      endState.isInstanceOf[MateState] should be (true)
    }

  }

}
