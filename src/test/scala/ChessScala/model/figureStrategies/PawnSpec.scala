package ChessScala.model.figureStrategies
import org.scalatest.matchers.should.Matchers
import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import org.scalatest.wordspec.AnyWordSpec

class PawnSpec extends AnyWordSpec with Matchers {

  val pawnW: Pawn = new Pawn(White)
  val pawnB: Pawn = new Pawn(Black)
  val positionW: Coordinate = new Coordinate(0, 0)
  val positionB: Coordinate = new Coordinate(0, 7)
  val boardBuilder: BoardBuilder = new BoardBuilder(8)
  val board: Board = boardBuilder.createEmptyBoard()

  "A pawn " should {

    "return all possible moves when the board is empty" in {

      val movesW: Vector[Coordinate] = pawnW.getMoves(positionW, board)
      val movesB: Vector[Coordinate] = pawnB.getMoves(positionB, board)

      movesW should contain (Coordinate(0, 1))

      movesW should contain noneOf(Coordinate(0, 0), Coordinate(1, 0), Coordinate(0, 3), Coordinate(4, 5))


      movesB should contain(Coordinate(0, -1))

      movesB should contain noneOf(Coordinate(0, 7), Coordinate(1, 0), Coordinate(0, 3), Coordinate(4, 5))
    }

    "return all possible moves with the board containing a friend" in {

      val friend: Pawn = new Pawn(White)
      val boardPawn: Board = board.insert(Coordinate(2, 2), friend)

      val moves: Vector[Coordinate] = pawnW.getMoves(positionW, boardPawn)

      moves should contain(Coordinate(1, 1))

      moves should contain noneOf(Coordinate(2, 2), Coordinate(3, 3), Coordinate(4, 4))

    }

    "return all possible attacks with the board containing an enemy" in {

      val enemy: Pawn = new Pawn(Black)
      val boardEnemy: Board = board.insert(Coordinate(2, 2), enemy)

      val attacks: Vector[Coordinate] = pawnB.getMoves(positionB, boardEnemy)

      attacks should contain(Coordinate(2, 2))

      attacks should contain noneOf(Coordinate(3, 3), Coordinate(4, 4))

    }

  }

}
