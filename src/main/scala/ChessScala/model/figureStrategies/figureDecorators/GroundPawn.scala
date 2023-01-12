package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{Black, Figure, Pawn, Team}

class GroundPawn(team: Team) extends Pawn(team) {

  override val get: Figure = new Pawn(team)
  override val id : Int = if (team == Black) 13 else 14

  override def getMotion(position: Coordinate, board: Board): Vector[Coordinate] =
    val step = super.getMotion(position, board)
    if (step.isEmpty) Vector() else step.appendedAll(secondStep(board,position))

  private def secondStep(board: Board, coordinate: Coordinate): Vector[Coordinate] =
    val step = Coordinate(coordinate.x,coordinate.y + direction * 2)
    if (board.is_free(step)) Vector(step) else Vector()
}
