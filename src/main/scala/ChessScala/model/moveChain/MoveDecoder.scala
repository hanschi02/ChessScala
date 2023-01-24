package ChessScala.model.moveChain

import ChessScala.model.board.Coordinate

object MoveDecoder {
  def decode(input: String): Move =
    val start = Coordinate(input(0) - 'a', input(1) - '1')
    val target = Coordinate(input(2) - 'a', input(3) - '1')
    new Move(start, target)

}
