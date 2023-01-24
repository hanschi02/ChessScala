package ChessScala.model.figureStrategies.strategyImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.figureDecorators.CastleRook
import ChessScala.model.figureStrategies.*

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

object BlackKing extends Figure(Black) with King(Black) {
  override val id: Int = 5
}

object WhiteKing extends Figure(White) with King(White) {
  override val id: Int = 11
}