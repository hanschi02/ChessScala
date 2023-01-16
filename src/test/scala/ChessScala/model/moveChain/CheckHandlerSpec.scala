package ChessScala.model.moveChain

import ChessScala.model.board.Coordinate
import ChessScala.model.fileIO.FileIOInterface
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.stateImplementation.GameState
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckHandlerSpec extends AnyWordSpec with Matchers{
  "The checkhandler" should {
    "not execute a move, when the own king would be in check after that move" in {
      val fileIO: FileIOInterface = new FileIO
      val state: GameState = fileIO.load("testfiles/PawnE6Test").asInstanceOf[GameState]
      val move: Move = new Move(Coordinate(4,5), Coordinate(3,4))
      val handler = new MoveHandler(move)
      handler.handle(state).isEmpty should be (true)
    }
  }
}
