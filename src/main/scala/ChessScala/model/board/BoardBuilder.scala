package ChessScala.model.board

import ChessScala.model.figureStrategies.Figure

class BoardBuilder(size : Int) {
  
  val range: Seq[Int] = 0 until (size-1)

  val coordinates: Seq[Coordinate] = range.flatMap{ x => range.map(y => new Coordinate(x, y))}

  def createEmptyBoard() : Board = new Board(coordinates.map(k => (k, None)).toMap)

}
