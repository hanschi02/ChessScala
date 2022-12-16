package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import ChessScala.model.figureStrategies.{Black, Pawn, White}
import ChessScala.model.figureStrategies.figureDecorators.EnPassantPawn
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers


class GroundPawnSpec extends AnyWordSpec with Matchers{

  "A ground-pawn " should {

    val pawn: Pawn = new GroundPawn(White)
    val position: Coordinate = Coordinate(0, 1)
    val boardBuilder: BoardBuilder = new BoardBuilder(8)
    val board: Board = boardBuilder.createEmptyBoard()

    "return all possible moves when the board is empty" in {

      val moves: Vector[Coordinate] = pawn.getMoves(position, board)

      moves should contain (Coordinate(0, 2))
      moves should contain (Coordinate(0, 3))

      moves should contain noneOf(Coordinate(0, 0), Coordinate(0, 1), Coordinate(1, 1), Coordinate(0, 4))

    }

    "return all possible moves with the board containing a friend" in {

      val friend: Pawn = new Pawn(White)
      val boardPawn: Board = board.insert(Coordinate(0, 3), friend)
      val moves: Vector[Coordinate] = pawn.getMoves(position, boardPawn)

      moves should not contain (Coordinate(0, 3))

      val newBoard: Board = board.insert(Coordinate(0,2), friend)
      val newMoves: Vector[Coordinate] = pawn.getMoves(position, newBoard)
      newMoves.isEmpty should be (true)
    }

    "do a move" in {
      val builder = new BoardBuilder(8)
      var board = builder.createEmptyBoard()
      val pawn = new GroundPawn(White)
      board.insert(Coordinate(0,0), pawn)
      var newPawn = pawn.move(Coordinate(0,0), Coordinate(0,1), board).get(Coordinate(0,1)).get
      newPawn.isInstanceOf[Pawn] should be (true)
      newPawn.isInstanceOf[EnPassantPawn] should be (false)

      newPawn = pawn.move(Coordinate(0, 0), Coordinate(0, 2), board).map(Coordinate(0, 2)).get
      newPawn.isInstanceOf[EnPassantPawn] should be (true)


    }
  }
}
