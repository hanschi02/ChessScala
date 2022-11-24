package ChessScala.model.gameState
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.model.figureStrategies.{Black, Team, White}
import ChessScala.model.board._
import ChessScala.model.interpreter.{Interpreter, SelectInterpreter}

class SelectStateSpec extends AnyWordSpec with Matchers {

  val boardBuilder : BoardBuilder = new BoardBuilder(8)
  val board : Board = boardBuilder.createChessBoard()
  val state : SelectState = new SelectState(White, Coordinate(0, 0), board)
  val stateBlack : SelectState = new SelectState(Black, Coordinate(0, 0), board)


  "The SelectState" should {

    "return the correct figures " in {

      var result = state.handle("queen")

      result._1.isInstanceOf[GameState] should be (true)
      result._2 should be ("Queen selected")

      result = state.handle("rook")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Rook selected")

      result = state.handle("Knight")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Knight selected")

      result = state.handle("Bishop")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Bishop selected")


      result = stateBlack.handle("queen")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Queen selected")

      result = stateBlack.handle("rook")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Rook selected")

      result = stateBlack.handle("Knight")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Knight selected")

      result = stateBlack.handle("Bishop")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("Bishop selected")

    }

    "return an excpetion when there's a wrong input" in {

      val result = state.handle("king")

      result._1.isInstanceOf[GameState] should be(false)
      result._2 should be("Non eligibale figure")

    }


  }

}
