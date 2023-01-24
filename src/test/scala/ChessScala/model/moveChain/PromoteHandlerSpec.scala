package ChessScala.model.moveChain

import ChessScala.model.fileIO.FileIOInterface
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.stateImplementation.{GameState, SelectState}
import ChessScala.model.moveChain.ChainImplementations.SwitchHandler
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PromoteHandlerSpec extends AnyWordSpec with Matchers{
  val fileIO: FileIOInterface = new FileIO
  val resetHandler : SwitchHandler = new SwitchHandler

  "The Promote handler should" should {
    "switch from gamestate to selectstate" in {
      var state = fileIO.load("testfiles/Promotion-A-Line-Test")
      state = state.handle("a7a8")._1
      state.isInstanceOf[SelectState] should be (true)
    }

    "stay in gamestate when the figure is not a pawn" in {
      var state = fileIO.load("testfiles/QueenG6Test")
      state = state.handle("g7g8")._1
      state.isInstanceOf[GameState] should be (true)
    }
  }

}
