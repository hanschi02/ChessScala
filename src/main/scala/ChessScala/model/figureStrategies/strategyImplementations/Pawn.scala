package ChessScala.model.figureStrategies.strategyImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.figureDecorators.EnPassantPawn
import ChessScala.model.figureStrategies.{Black, Figure, Team, White}

class Pawn(override val team: Team) extends Figure(team) {

  val direction: Int = if (team == White) 1 else -1
  override val id: Int = if(team == Black) 6 else 12
  override def getAttacks(position: Coordinate, board: Board): Vector[Coordinate] =
    Vector(Coordinate(position.x + 1, position.y + direction), Coordinate(position.x - 1, position.y + direction))
      .filter(board.is_occupied)
      .filter(board.get(_).get.team != team)
      .appendedAll(enPassant(position, board))

  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    Vector(Coordinate(position.x, position.y + direction)).filter(board.is_free)

  private def enPassant(position: Coordinate, board: Board): Vector[Coordinate] =
    Vector(Coordinate(position.x + 1, position.y), Coordinate(position.x - 1, position.y))
      .filter(board.is_occupied)
      .filter(k => (board.get(k).get.team != team) && (board.get(k).get.isInstanceOf[EnPassantPawn]))
      .map(k => Coordinate(k.x, k.y + direction))

  override def move(start: Coordinate, target: Coordinate, board: Board): Board =
    if (enPassant(start,board).contains(target))
      board.delete(start).delete(Coordinate(target.x, target.y - direction)).insert(target,this.get)
    else super.move(start, target, board)
}
