package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.figureStrategies.{Black, Pawn, Team}

class EnPassantPawn(team: Team) extends Pawn(team) {
  
  override val id : Int = if (team == Black) 15 else 16
}
