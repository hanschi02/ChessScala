package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.figureStrategies.{Black, White}
import ChessScala.model.gameState.*
import ChessScala.model.gameState.stateImplementation.*
import ChessScala.model.moveChain.GameChain


class SwitchHandler extends GameChain{

  override val next: GameChain = new ResetHandler
  override def handle(state: GameState): Option[ProgrammState] =
    val nextTeam = if (state.team == White) Black else White
    next.handle((new GameState(nextTeam, state.board)))

}
