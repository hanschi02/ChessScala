package ChessScala.model.moveChain

import ChessScala.model.figureStrategies.{Black, White}
import ChessScala.model.gameState._
import ChessScala.model.gameState.stateImplementation._

import ChessScala.model.moveChain.GameChain
import ChessScala.model.gameState.stateImplementation._


class SwitchHandler extends GameChain{

  override val next: GameChain = new ResetHandler
  override def handle(state: GameState): Option[ProgrammState] =
    val nextTeam = if (state.team == White) Black else White
    next.handle((new GameState(nextTeam, state.board)))

}
