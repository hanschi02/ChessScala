package ChessScala.model.board
import ChessScala.model.figureStrategies.Figure

class Board(val map: Map[Coordinate, Option[Figure]]) {

  def insert(coordinate: Coordinate, figure: Option[Figure]): Board = new Board(map + (coordinate -> figure))

  def insert(coordinate: Coordinate, figure: Figure) : Board = insert(coordinate, Some(figure))

  def delete(coordinate: Coordinate) : Board = insert(coordinate, None)

}
