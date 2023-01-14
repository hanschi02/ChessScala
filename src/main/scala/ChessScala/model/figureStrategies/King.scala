package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.WhiteCastleKing.{castle, o_o, o_o_o, y}
import ChessScala.model.figureStrategies.figureDecorators.CastleRook

trait King(team: Team) {
  val y = if (team == White) 0 else 7

  val directions: Vector[(Int, Int)] = Vector((1, 0), (-1, 0), (0, 1), (0, -1),(1, 1), (1, -1), (-1, 1), (-1, -1))
  def getDirectionVector(position: Coordinate): Vector[Coordinate] =
    directions.map(k => Coordinate(position.x + k._1, position.y + k._2))

  def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_occupied).filter(board.get(_).get.team != team)

  def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_free)

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

object BlackKing extends Figure(Black) with King(Black) {
  override val id: Int = 5
}

object WhiteKing extends Figure(White) with King(White) {
  override val id: Int = 11
}

object WhiteCastleKing extends Figure(White) with King(White) {
  override val id: Int = 11
  override val get: Figure = WhiteKing

  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    super.getMotion(position,board).appendedAll(castle(board))

  //override def move(start: Coordinate, target: Coordinate, board: Board): Board =
   // if (target.x = 6) super.move(start,target, board).delete(Coordinate(7,y))
   // if (target.x = 6) super.move(start,target, board).delete(Coordinate(7,y))
}

object BlackCastleKing extends Figure(Black) with King(Black) {
  override val id: Int = 5
  override val get: Figure = BlackKing

  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    super.getMotion(position,board).appendedAll(castle(board))

}