package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class KnightSpec extends AnyWordSpec with Matchers {

  val knight : Knight = new Knight(White)
  val position : Coordinate = new Coordinate(0, 0)

  "A knight " should {

    "return all possible moves when the board is empty" in {

      // val board : Board = new Board()
      // val moves : Vector[Coordinate] = ()

    }

  }



}
