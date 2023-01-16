package ChessScala.model.moveChain

import ChessScala.model.board.Coordinate
import ChessScala.model.fileIO.FileIOInterface
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState

class CastleHandlerSpec extends AnyWordSpec with Matchers {

  val fileIO: FileIOInterface = new FileIO
  val resetHandler : SwitchHandler = new SwitchHandler

  "The castle-handler" should {
    "execute the little castle for White" in {
      val state: GameState = fileIO.load("testfiles/CastleTest").asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,0),Coordinate(6,0))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      littleCastleState.isDefined should be (true)
    }

    "execute the big castle for White" in {
      val state: GameState = fileIO.load("testfiles/CastleTest").asInstanceOf[GameState]
      val bigCastle = new Move(Coordinate(4,0),Coordinate(2,0))
      val bigCastleHandler = new MoveHandler(bigCastle)
      val bigCastleState = bigCastleHandler.handle(state)
      bigCastleState.isDefined should be (true)
    }

    "execute the little castle for Black" in {
        val firstState: GameState = fileIO.load("testfiles/CastleTest").asInstanceOf[GameState]
        val state = resetHandler.handle(firstState).get.asInstanceOf[GameState]
        val littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
        val littleCastleHandler = new MoveHandler(littleCastle)
        val littleCastleState = littleCastleHandler.handle(state)
        littleCastleState.isDefined should be (true)
    }

    "execute the big castle for Black" in {
        val firstState: GameState = fileIO.load("testfiles/CastleTest").asInstanceOf[GameState]
        val state = resetHandler.handle(firstState).get.asInstanceOf[GameState]
        val bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
        val bigCastleHandler = new MoveHandler(bigCastle)
        val bigCastleState = bigCastleHandler.handle(state)
        bigCastleState.isDefined should be (true)
    }

    "not castle for Black when the way is blocked" in {
      var state: GameState = fileIO.load("testfiles/OccupiedCastleTest").asInstanceOf[GameState]
      var littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
      var bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
      var littleCastleHandler = new MoveHandler(littleCastle)
      var bigCastleHandler = new MoveHandler(bigCastle)
      var littleCastleState = littleCastleHandler.handle(state)
      var bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
      state = resetHandler.handle(state).get.asInstanceOf[GameState]
      littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
      bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
      littleCastleHandler = new MoveHandler(littleCastle)
      bigCastleHandler = new MoveHandler(bigCastle)
      littleCastleState = littleCastleHandler.handle(state)
      bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for White when the way is blocked" in {
      val state: GameState = fileIO.load("testfiles/OccupiedCastleTest").asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,0),Coordinate(6,0))
      val bigCastle = new Move(Coordinate(4,0),Coordinate(2,0))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for White when the way is attacked" in {
      val firstState: GameState = fileIO.load("testfiles/AttackedCastleTest1").asInstanceOf[GameState]
      val state = resetHandler.handle(firstState).get.asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,0),Coordinate(6,0))
      val bigCastle = new Move(Coordinate(4,0),Coordinate(2,0))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for White when the way is attacked 2" in {
      val firstState: GameState = fileIO.load("testfiles/AttackedCastleTest2").asInstanceOf[GameState]
      val state = resetHandler.handle(firstState).get.asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,0),Coordinate(6,0))
      val bigCastle = new Move(Coordinate(4,0),Coordinate(2,0))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for Black when the way is attacked" in {
      val state: GameState = fileIO.load("testfiles/AttackedCastleTest1").asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
      val bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for Black when the way is attacked 2" in {
      val state: GameState = fileIO.load("testfiles/AttackedCastleTest2").asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
      val bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for Black when the king was moved" in {
      val state: GameState = fileIO.load("testfiles/CastleMovedTest").asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
      val bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for White when the king was moved" in {
      val firstState: GameState = fileIO.load("testfiles/CastleMovedTest").asInstanceOf[GameState]
      val state = resetHandler.handle(firstState).get.asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,0),Coordinate(6,0))
      val bigCastle = new Move(Coordinate(4,0),Coordinate(2,0))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for Black when no Rooks are there" in {
      val state: GameState = fileIO.load("testfiles/NoRooksCastleTest").asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,7),Coordinate(6,7))
      val bigCastle = new Move(Coordinate(4,7),Coordinate(2,7))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "not castle for White when no Rooks are there" in {
      val firstState: GameState = fileIO.load("testfiles/NoRooksCastleTest").asInstanceOf[GameState]
      val state = resetHandler.handle(firstState).get.asInstanceOf[GameState]
      val littleCastle = new Move(Coordinate(4,0),Coordinate(6,0))
      val bigCastle = new Move(Coordinate(4,0),Coordinate(2,0))
      val littleCastleHandler = new MoveHandler(littleCastle)
      val bigCastleHandler = new MoveHandler(bigCastle)
      val littleCastleState = littleCastleHandler.handle(state)
      val bigCastleState = bigCastleHandler.handle(state)
      littleCastleState.isDefined should be (false)
      bigCastleState.isDefined should be (false)
    }

    "go to next handler then the piece is not a king" in {
      var state: ProgrammState = fileIO.load("testfiles/QueenE4Test").asInstanceOf[GameState]
      state = state.handle("e1d1")._1
      state.isInstanceOf[GameState] should be (true)
      state = state.handle("e8e7")._1
      state = resetHandler.handle(state.asInstanceOf[GameState]).get
      state.handle("e7e8")._1.isInstanceOf[GameState] should be (true)
    }
  }
}
