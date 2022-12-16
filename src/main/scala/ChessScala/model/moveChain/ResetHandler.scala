package ChessScala.model.moveChain

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies._
import ChessScala.model.figureStrategies.figureDecorators.EnPassantPawn
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation._


class ResetHandler extends GameChain {

  override val next: GameChain = this

  def reset(figure: Option[Figure]) : Option[Figure] =
    if (figure.isEmpty) return None
    if (figure.get.isInstanceOf[EnPassantPawn]) return Some(new Pawn(figure.get.team))
    figure

  override def handle(state: GameState): Option[ProgrammState] =
    val board: Board = state.board.foreach(state.team, reset)
    Some(new GameState(state.team, board))
}
