package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.figureDecorators.CastleRook

trait King(team: Team) {
  val y: Int = if (team == White) 0 else 7

  val directions: Vector[(Int, Int)] = Vector((1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1))
  val castleFields: Vector[Coordinate] =
    if (team == White) Vector(Coordinate(2,0), Coordinate(6,0)) else Vector(Coordinate(2,7), Coordinate(6,7))

  val startField: Coordinate = if (team == White) Coordinate(4,0) else Coordinate(4,7)

  def getCastleFields(c: Coordinate): Vector[Coordinate] = if (c == startField) castleFields else Vector[Coordinate]()

  def getDirectionVector(position: Coordinate): Vector[Coordinate] =
    directions.map(k => Coordinate(position.x + k._1, position.y + k._2)).appendedAll(getCastleFields(position))

  def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_occupied).filter(board.get(_).get.team != team)

  def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_free)
}
  /*
  def o_o(board: Board): Boolean =
    if (board.is_free(Coordinate(7, y))) return false
    if (!board.get(Coordinate(7, y)).get.isInstanceOf[CastleRook]) return false
    if ((4 to 7).map(Coordinate(_,y)).exists(board.is_attacked(_, team))) return false
    if ((5 to 6).map(Coordinate(_,y)).forall(board.is_free)) return false
    true

  def o_o_o(board: Board): Boolean =
    if (board.is_free(Coordinate(0, y))) return false
    if (!board.get(Coordinate(0, y)).get.isInstanceOf[CastleRook]) return false
    if ((4 to 0).map(Coordinate(_,y)).exists(board.is_attacked(_, team))) return false
    if ((3 to 1).map(Coordinate(_,y)).forall(board.is_free)) return false
    true

  def castle(board: Board): Vector[Coordinate] =
    val appendable: Vector[Coordinate] = if (o_o(board)) Vector(Coordinate(6,y)) else Vector()
    if (o_o_o(board)) appendable.appended(Coordinate(2,7)) else appendable
}
*/
object BlackKing extends Figure(Black) with King(Black) {
  override val id: Int = 5
}

object WhiteKing extends Figure(White) with King(White) {
  override val id: Int = 11
}