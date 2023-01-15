package ChessScala.model.board

import ChessScala.model.board
import ChessScala.model.figureStrategies._
import ChessScala.model.figureStrategies.figureDecorators._

class BoardBuilder(size : Int) {
  
  val range: Seq[Int] = 0 until size

  val coordinates: Seq[Coordinate] = range.flatMap{ x => range.map(y => new Coordinate(x, y))}

  def createEmptyBoard() : Board = new Board(coordinates.map(k => (k, None)).toMap)
  
  def createChessBoard() : Board =
    insertPawns(createEmptyBoard())
      .insert(Coordinate(0,7), new CastleRook(Black))
      .insert(Coordinate(1,7), new Knight(Black))
      .insert(Coordinate(2,7), new Bishop(Black))
      .insert(Coordinate(3,7), new Queen(Black))
      .insert(Coordinate(4,7), BlackKing)
      .insert(Coordinate(5,7), new Bishop(Black))
      .insert(Coordinate(6,7), new Knight(Black))
      .insert(Coordinate(7,7), new CastleRook(Black))
      .insert(Coordinate(0, 0), new CastleRook(White))
      .insert(Coordinate(1, 0), new Knight(White))
      .insert(Coordinate(2, 0), new Bishop(White))
      .insert(Coordinate(3, 0), new Queen(White))
      .insert(Coordinate(4, 0), WhiteKing)
      .insert(Coordinate(5, 0), new Bishop(White))
      .insert(Coordinate(6, 0), new Knight(White))
      .insert(Coordinate(7, 0), new CastleRook(White))



  def insertPawn(board : Board, team: Team, i : Int = 0) : Board =
    if(i > 7) board
    else insertPawn(board.insert(Coordinate(i, if(team == White) 1 else 6), new GroundPawn(team)), team, i+1)


  def insertPawns(board : Board) : Board =
    val newBoard = insertPawn(board, Black)
    insertPawn(newBoard, White)


}
