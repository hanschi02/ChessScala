package ChessScala.model.gameState

import ChessScala.model.figureStrategies.Team

class EndState(team: Team) extends ProgrammState {

  override def handle(input: String): ProgrammState = this
}
