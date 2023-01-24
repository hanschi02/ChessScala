package ChessScala.model.fileIO.fileIOXML

import ChessScala.model.board.{BoardBuilder, Coordinate}
import ChessScala.model.figureStrategies.White
import ChessScala.model.figureStrategies.strategyImplementations.Pawn
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.model.fileIO.fileIOXML.FileIO
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState


class FileIOSpec extends AnyWordSpec with Matchers{
  "The XML-FileIO" should {
    "save and load the Gamestate" in {
      val fileIO = new FileIO
      val board = (new BoardBuilder(8)).createChessBoard()
      var state: ProgrammState = new GameState(White, board)
      state = state.handle("e2e4")._1.asInstanceOf[GameState]
      fileIO.save(state)
      state = fileIO.load("Chess")
      state.board.get(Coordinate(4,3)).isDefined should be (true)
      state = state.handle("e7e5")._1.asInstanceOf[GameState]
      fileIO.save(state)
      state = fileIO.load("Chess")
      state.board.get(Coordinate(4,4)).isDefined should be (true)

    }
  }
}
