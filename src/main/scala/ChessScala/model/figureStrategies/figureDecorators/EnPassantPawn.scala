package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.figureStrategies.{Figure, Pawn, Team}

class EnPassantPawn(team: Team) extends Pawn(team){
  override val get: Figure = new Pawn(team)
}
