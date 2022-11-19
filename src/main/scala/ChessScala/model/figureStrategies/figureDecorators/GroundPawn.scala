package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.figureStrategies.{Figure, Pawn, Team}

class GroundPawn(team: Team) extends Pawn(team) {

  override def get(): Figure = new Pawn(team)
}
