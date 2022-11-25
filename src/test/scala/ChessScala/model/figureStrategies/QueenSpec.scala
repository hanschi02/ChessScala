package ChessScala.model.figureStrategies
import org.scalatest.matchers.should.Matchers
import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import org.scalatest.wordspec.AnyWordSpec

class QueenSpec extends AnyWordSpec with Matchers {

  val queen: Queen = new Queen(White)
  val position: Coordinate = new Coordinate(0, 0)
  val boardBuilder: BoardBuilder = new BoardBuilder(8)
  val board: Board = boardBuilder.createEmptyBoard()

  "A queen " should {

    "return all possible moves when the board is empty" in {

      val moves: Vector[Coordinate] = queen.getMoves(position, board)

      val expected: Vector[Coordinate] =
        (new Bishop(White)).getMoves(position, board).appendedAll((new Rook(White)).getMoves(position, board))

      expected.foreach(moves should contain (_))

      moves should contain noneOf(Coordinate(1, 2), Coordinate(2, 1), Coordinate(0, 0))
    }

    "return all possible moves with the board containing a friend" in {

      val friend: Pawn = new Pawn(White)
      val boardPawn: Board = board.insert(Coordinate(2, 0), friend).insert(Coordinate(2, 2), friend)

      val expected: Vector[Coordinate] =
        (new Bishop(White)).getMoves(position, boardPawn).appendedAll((new Rook(White)).getMoves(position, boardPawn))

      val moves: Vector[Coordinate] = queen.getMoves(position, boardPawn)

      expected.foreach(moves should contain (_))

      moves should contain noneOf(Coordinate(2, 0), Coordinate(2, 2), Coordinate(0, 0))

    }

    "return all possible attacks with the board containing an enemy" in {

      val enemy: Pawn = new Pawn(Black)
      val boardEnemy: Board = board.insert(Coordinate(0, 1), enemy).insert(Coordinate(1, 1), enemy)

      val expected: Vector[Coordinate] =
        (new Bishop(Black)).getMoves(position, boardEnemy).appendedAll((new Rook(Black)).getMoves(position, boardEnemy))

      val attacks: Vector[Coordinate] = queen.getMoves(position, boardEnemy)

      expected.foreach(attacks should contain (_))

      attacks should contain noneOf(Coordinate(0, 0), Coordinate(4, 7), Coordinate(0, 2), Coordinate(2, 2))

    }

  }

}
