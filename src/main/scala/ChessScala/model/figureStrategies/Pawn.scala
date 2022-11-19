package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}

class Pawn(override val team: Team) extends Figure(team) {

  val direction: Int = if (team == White) 1 else -1

  override def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] = Vector()

  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] = Vector()

}
