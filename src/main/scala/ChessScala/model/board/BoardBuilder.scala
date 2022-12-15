package ChessScala.model.board

import ChessScala.model.board
import ChessScala.model.figureStrategies.{Queen, *}

class BoardBuilder(size : Int) {
  
  val range: Seq[Int] = 0 until size

  val coordinates: Seq[Coordinate] = range.flatMap{ x => range.map(y => new Coordinate(x, y))}

  def createEmptyBoard() : Board = new Board(coordinates.map(k => (k, None)).toMap)
  
  def createChessBoard() : Board =
    insertPawns(createEmptyBoard())
      .insert(Coordinate(7,0), new Rook(Black))
      .insert(Coordinate(7,1), new Knight(Black))
      .insert(Coordinate(7,2), new Bishop(Black))
      .insert(Coordinate(7,3), new Queen(Black))
      .insert(Coordinate(7,4), BlackKing)
      .insert(Coordinate(7,5), new Bishop(Black))
      .insert(Coordinate(7,6), new Knight(Black))
      .insert(Coordinate(7,7), new Rook(Black))
      .insert(Coordinate(0, 0), new Rook(White))
      .insert(Coordinate(0, 1), new Knight(White))
      .insert(Coordinate(0, 2), new Bishop(White))
      .insert(Coordinate(0, 3), new Queen(White))
      .insert(Coordinate(0, 4), WhiteKing)
      .insert(Coordinate(0, 5), new Bishop(White))
      .insert(Coordinate(0, 6), new Knight(White))
      .insert(Coordinate(0, 7), new Rook(White))



  def insertPawn(board : Board, team: Team, i : Int = 0) : Board =
    if(i > 7) board
    else insertPawn(board.insert(Coordinate(if(team == White) 1 else 6, i), new Pawn(team)), team, i+1)


  def insertPawns(board : Board) : Board =
    val newBoard = insertPawn(board, Black)
    insertPawn(newBoard, White)


}
