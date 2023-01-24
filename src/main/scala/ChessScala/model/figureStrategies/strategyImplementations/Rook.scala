package ChessScala.model.figureStrategies.strategyImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.figureBridge.{FigureBridge, MoveBridge}
import ChessScala.model.figureStrategies.{Black, Figure, Team}

class Rook(override val team: Team) extends Figure(team) {

  override val id: Int = if(team == Black) 1 else 7
  private val bridge : FigureBridge = new MoveBridge
  val directions: Vector[Coordinate] = bridge.rookDirections

  def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] =
    directions.flatMap(k=> bridge.getAttacks(board,position,k))
      .filter(board.get(_).get.team != team)


  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    directions.flatMap(k=> bridge.getMotion(board,position,k))
}
