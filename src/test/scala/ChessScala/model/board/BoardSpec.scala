package ChessScala.model.board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.model.board.{BoardBuilder, Coordinate}
import ChessScala.model.figureStrategies.White
import ChessScala.model.figureStrategies.strategyImplementations.{Pawn, Queen, WhiteKing}

class BoardSpec extends AnyWordSpec with Matchers {
  "a board" should {
    val builder = new BoardBuilder(8)
    val position = Coordinate(0, 0)
    val board = builder.createEmptyBoard().insert(position, WhiteKing)
    "delete a figure" in {
      board.delete(position).get(position) should be (None)

    }
    "have a foreach function" in {
      val newBoard = board.insert(Coordinate(2, 2), new Pawn(White))
      val queens = newBoard.foreach(White, k=> Some(new Queen(k.get.team)))
      queens.get(position).get.isInstanceOf[Queen] should be (true)
      queens.get(Coordinate(2, 2)).get.isInstanceOf[Queen] should be (true)
    }
  }
}
