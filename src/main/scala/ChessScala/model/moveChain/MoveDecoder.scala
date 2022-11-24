package ChessScala.model.moveChain

import ChessScala.model.board.Coordinate

object MoveDecoder{
  def decode(input: String): Move =
    val start = Coordinate(0,0)
    val target = Coordinate(0,0)
    new Move(start, target)
    
}
