package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class KnightSpec extends AnyWordSpec with Matchers {

  val knight : Knight = new Knight(White)
  val position : Coordinate = new Coordinate(0, 0)
  val boardBuilder : BoardBuilder = new BoardBuilder(8)
  val board : Board = boardBuilder.createEmptyBoard()

  "A knight " should {

    "return all possible moves when the board is empty" in {

      val moves : Vector[Coordinate] = knight.getMoves(position, board)

      moves should contain allOf(Coordinate(1, 2), Coordinate(2, 1), Coordinate(1,-2), Coordinate(-1,2),
        Coordinate(-1,-2), Coordinate(-2,1), Coordinate(2,-1), Coordinate(-2,-1))

      moves should contain noneOf(Coordinate(0,0), Coordinate(1,1), Coordinate(1,0), Coordinate(4,5))
    }
    
    "return all possible moves with the board containing a friend" in {
      
      val friend : Pawn = new Pawn(White)
      val boardPawn : Board = board.insert(Coordinate(1,2), friend).insert(Coordinate(2,1), friend)

      val moves : Vector[Coordinate] = knight.getMoves(position, boardPawn)
      
      moves should contain allOf(Coordinate(1, -2), Coordinate(-1, 2),
        Coordinate(-1, -2), Coordinate(-2, 1), Coordinate(2, -1), Coordinate(-2, -1))

      moves should contain noneOf(Coordinate(1,2), Coordinate(2,1), Coordinate(1,0), Coordinate(4,5))
      
    }
    
    "return all possible attacks with the board containing an enemy" in {
      
      val enemy : Pawn = new Pawn(Black)
      val boardEnemy : Board = board.insert(Coordinate(1, 2), enemy).insert(Coordinate(2,1), enemy)
      
      val attacks : Vector[Coordinate] = knight.getMoves(position, boardEnemy)
      
      attacks should contain allOf(Coordinate(1,2), Coordinate(2,1))
      
      attacks should contain noneOf(Coordinate(0,0), Coordinate(1,1), Coordinate(1,0), Coordinate(4,5))
      
    }

  }



}
