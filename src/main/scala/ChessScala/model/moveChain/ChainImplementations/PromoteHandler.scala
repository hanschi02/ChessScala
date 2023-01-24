package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.board.Coordinate
import ChessScala.model.figureStrategies.White
import ChessScala.model.figureStrategies.strategyImplementations.Pawn
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.{GameState, SelectState}
import ChessScala.model.moveChain.GameChain

class PromoteHandler(target: Coordinate) extends GameChain {

  override val next: GameChain = new MateHandler

  override def handle(state: GameState): Option[ProgrammState] =
    val end : Int = if (state.team == White) 7 else 0
    if (target.y != end) return next.handle(state)
    if (!state.board.get(target).get.isInstanceOf[Pawn]) return next.handle(state)
    Some(new SelectState(state.team,target,state.board))

}
