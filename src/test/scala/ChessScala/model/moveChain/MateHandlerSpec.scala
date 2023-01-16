package ChessScala.model.moveChain

import ChessScala.model.board.Coordinate
import ChessScala.model.fileIO.FileIOInterface
import ChessScala.model.gameState.stateImplementation.{GameState, MateState}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.ProgrammState

import scala.reflect.internal.util.Position


class MateHandlerSpec extends AnyWordSpec with Matchers{
  val fileIO: FileIOInterface = new FileIO
  val resetHandler : SwitchHandler = new SwitchHandler

  "The Mate handler should" should {
    "finish the game when white is checkmate" in {
      val state: GameState = fileIO.load("testfiles/WhiteIsMateTest").asInstanceOf[GameState]
      val blackQueenMove: Move = new Move(Coordinate(3,7), Coordinate(7,3))
      val handler: MoveHandler = new MoveHandler(blackQueenMove)
      val endState: Option[ProgrammState] = handler.handle(state)
      endState.isDefined should be (true)
      endState.get.isInstanceOf[MateState] should be (true)
      endState.get.asInstanceOf[MateState].result should be ("Checkmate, Black wins!")
    }

    "finish the game when it is stalemate" in {
      val state: GameState = fileIO.load("testfiles/e7c7StalemateTest").asInstanceOf[GameState]
      val whiteQueenMove: Move = new Move(Coordinate(4,6), Coordinate(2,6))
      val handler: MoveHandler = new MoveHandler(whiteQueenMove)
      val endState: Option[ProgrammState] = handler.handle(state)
      endState.isDefined should be (true)
      endState.get.isInstanceOf[MateState] should be (true)
      endState.get.asInstanceOf[MateState].result should be ("Stalemate, draw!")
    }

  }
}
