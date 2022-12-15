package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}

trait King(team: Team) {
  val directions: Vector[(Int, Int)] = Vector((1, 0), (-1, 0), (0, 1), (0, -1),(1, 1), (1, -1), (-1, 1), (-1, -1))
  def getDirectionVector(position: Coordinate): Vector[Coordinate] =
    directions.map(k => Coordinate(position.x + k._1, position.y + k._2))

  def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_occupied).filter(board.get(_).get.team != team)

  def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_free)

}

object BlackKing extends Figure(Black) with King(Black) {
  override val id: Int = 5
}

object WhiteKing extends Figure(White) with King(White) {
  override val id: Int = 11
}
