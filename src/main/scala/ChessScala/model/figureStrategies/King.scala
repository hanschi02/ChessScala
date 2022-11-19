package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}

trait King {

  protected def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] = Vector()

  protected def getMotion(position: Coordinate, board: Board): Vector[Coordinate] = Vector()

}

object BlackKing extends Figure(Black) with King

object WhiteKing extends Figure(White) with King
