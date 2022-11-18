package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}

class Queen(override val team: Team) extends Figure(team) {

  override def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] = Vector()

  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] = Vector()

}
