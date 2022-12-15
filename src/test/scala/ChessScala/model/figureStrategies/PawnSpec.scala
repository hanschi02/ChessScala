package ChessScala.model.figureStrategies
import org.scalatest.matchers.should.Matchers
import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import ChessScala.model.figureStrategies.figureDecorators.EnPassantPawn
import org.scalatest.wordspec.AnyWordSpec

class PawnSpec extends AnyWordSpec with Matchers {


  "A white pawn " should {

    val pawn: Pawn = new Pawn(White)
    val position: Coordinate = Coordinate(0, 0)
    val boardBuilder: BoardBuilder = new BoardBuilder(8)
    val board: Board = boardBuilder.createEmptyBoard()

    "return all possible moves when the board is empty" in {

      val moves: Vector[Coordinate] = pawn.getMoves(position, board)

      moves should contain (Coordinate(0, 1))

      moves should contain noneOf(Coordinate(0, 0), Coordinate(1, 0), Coordinate(1, 1), Coordinate(0, 2))

    }

    "return all possible moves with the board containing a friend" in {

      val friend: Pawn = new Pawn(White)
      val boardPawn: Board = board.insert(Coordinate(0, 1), friend).insert(Coordinate(1,1), friend)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardPawn)

      moves.isEmpty should be (true)
    }

    "return all possible attacks with the board containing an enemy" in {

      val enemy: Pawn = new Pawn(Black)
      val boardEnemy: Board = board.insert(Coordinate(0, 1), enemy).insert(Coordinate(1, 1), enemy)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardEnemy)
      moves should contain (Coordinate(1, 1))
      moves should contain noneOf(Coordinate(0, 0), Coordinate(0, 1))
      val newBoard = pawn.move(position, Coordinate(0,1), boardEnemy)
      newBoard.get(Coordinate(0, 1)).get should be (pawn)
    }

    "attack en passant" in {
      val enemy: Pawn = new EnPassantPawn(Black)
      val boardEnemy: Board = board.insert(Coordinate(1, 0), enemy)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardEnemy)
      moves should contain (Coordinate(1, 1))
      val newBoard : Board = pawn.move(position, Coordinate(1,1),boardEnemy)
      newBoard.get(Coordinate(1,0)) should be (None)
    }
  }

  "A black pawn " should {

    val pawn: Pawn = new Pawn(Black)
    val position: Coordinate = Coordinate(0, 7)
    val boardBuilder: BoardBuilder = new BoardBuilder(8)
    val board: Board = boardBuilder.createEmptyBoard()

    "return all possible moves when the board is empty" in {

      val moves: Vector[Coordinate] = pawn.getMoves(position, board)

      moves should contain(Coordinate(0, 6))

      moves should contain noneOf(Coordinate(0, 7), Coordinate(1, 7), Coordinate(1, 6), Coordinate(0, 5))

    }

    "return all possible moves with the board containing a friend" in {

      val friend: Pawn = new Pawn(Black)
      val boardPawn: Board = board.insert(Coordinate(0, 6), friend).insert(Coordinate(1, 6), friend)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardPawn)

      moves.isEmpty should be(true)
    }

    "return all possible attacks with the board containing an enemy" in {

      val enemy: Pawn = new Pawn(White)
      val boardEnemy: Board = board.insert(Coordinate(0, 6), enemy).insert(Coordinate(1, 6), enemy)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardEnemy)
      moves should contain(Coordinate(1, 6))
      moves should contain noneOf(Coordinate(0, 7), Coordinate(0, 6))
    }

    "attack en passant" in {
      val enemy: Pawn = new EnPassantPawn(White)
      val boardEnemy: Board = board.insert(Coordinate(1, 7), enemy)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardEnemy)
      moves should contain (Coordinate(1, 6))
      boardEnemy.get(Coordinate(1,7)).get.isInstanceOf[EnPassantPawn] should be (true)
      val newBoard : Board = pawn.move(position, Coordinate(1,6),boardEnemy)
      newBoard.get(Coordinate(1,7)) should be (None)
    }
  }
}
