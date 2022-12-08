package ChessScala.model.moveChain

import ChessScala.model.board.Coordinate

object MoveDecoder{
  def decode(input: String): Move =
    val start = Coordinate(input(1)-'1', input(0)-'a')
    val target = Coordinate(input(3)-'1', input(2)-'a')
    new Move(start, target)
    
}
