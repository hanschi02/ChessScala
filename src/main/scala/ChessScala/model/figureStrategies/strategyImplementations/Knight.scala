package ChessScala.model.figureStrategies.strategyImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{Black, Figure, Team}


class Knight(override val team: Team) extends Figure(team) {

  private val directions = Vector((1,2),(1,-2),(-1,2),(-1,-2),(2,1),(-2,1),(2,-1),(-2,-1))

  override val id: Int = if(team == Black) 2 else 8

  def getDirectionVector(position: Coordinate): Vector[Coordinate] =
    directions.map(k => Coordinate(position.x + k._1, position.y + k._2))

  def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_occupied).filter(board.get(_).get.team != team)

  def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    getDirectionVector(position).filter(board.is_free)

}
