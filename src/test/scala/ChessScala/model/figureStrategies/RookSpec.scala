package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RookSpec extends AnyWordSpec with Matchers {

  val rook: Rook = new Rook(White)
  val position: Coordinate = new Coordinate(0, 0)
  val boardBuilder: BoardBuilder = new BoardBuilder(8)
  val board: Board = boardBuilder.createEmptyBoard()

  "A rook " should {

    "return all possible moves when the board is empty" in {

      val moves: Vector[Coordinate] = rook.getMoves(position, board)

      moves should contain allOf(Coordinate(0, 1), Coordinate(0, 2), Coordinate(1, 0), Coordinate(2, 0))

      moves should contain noneOf(Coordinate(1, 1), Coordinate(5, 6), Coordinate(2, 3), Coordinate(4, 5), Coordinate(0, 0))
    }

    "return all possible moves with the board containing a friend" in {

      val friend: Pawn = new Pawn(White)
      val boardPawn: Board = board.insert(Coordinate(2, 0), friend).insert(Coordinate(0, 2), friend)

      val moves: Vector[Coordinate] = rook.getMoves(position, boardPawn)

      moves should contain allOf(Coordinate(1, 0), Coordinate(0, 1))

      moves should contain noneOf(Coordinate(2, 0), Coordinate(0, 2), Coordinate(4, 4))

    }

    "return all possible attacks with the board containing an enemy" in {

      val enemy: Pawn = new Pawn(Black)
      val boardEnemy: Board = board.insert(Coordinate(0, 1), enemy).insert(Coordinate(1, 0), enemy)

      val attacks: Vector[Coordinate] = rook.getMoves(position, boardEnemy)

      attacks should contain allOf(Coordinate(0, 1), Coordinate(1,0))

      attacks should contain noneOf(Coordinate(0, 2), Coordinate(2, 0))

    }

  }

}
