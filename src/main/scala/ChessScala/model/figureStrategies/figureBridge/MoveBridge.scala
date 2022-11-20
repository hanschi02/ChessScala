package ChessScala.model.figureStrategies.figureBridge
import ChessScala.model.board._

class MoveBridge extends FigureBridge {

  val rookDirections: Vector[Coordinate] = Vector((1, 0), (-1, 0), (0, 1), (0, -1)).map(k => Coordinate(k._1, k._2))
  val bishopDirections: Vector[Coordinate] = Vector((1, 1), (1, -1), (-1, 1), (-1, -1)).map(k => Coordinate(k._1, k._2))

  override def getMotion(board: Board, place: Coordinate, target: Coordinate): Vector[Coordinate] =
    val next: Coordinate = Coordinate(place.x + target.x, place.y + target.y)
    if (!board.is_free(next)) return Vector[Coordinate]()
    Vector[Coordinate](next).appendedAll(getMotion(board, next, target))


  override def getAttacks(board: Board, place: Coordinate, target: Coordinate): Vector[Coordinate] =
    val next: Coordinate = Coordinate(place.x + target.x, place.y + target.y)
    if (!board.is_on_board(next)) return Vector[Coordinate]()
    if (board.is_occupied(next)) return Vector(next)
    getAttacks(board, next, target)

}
