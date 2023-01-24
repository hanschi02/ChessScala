package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.*
import ChessScala.model.figureStrategies.figureDecorators.EnPassantPawn
import ChessScala.model.figureStrategies.strategyImplementations.Pawn
import ChessScala.model.gameState.*
import ChessScala.model.gameState.stateImplementation.*
import ChessScala.model.moveChain.GameChain


class ResetHandler extends GameChain {

  override val next: GameChain = this

  def reset(figure: Option[Figure]) : Option[Figure] =
    if (figure.get.isInstanceOf[EnPassantPawn]) return Some(new Pawn(figure.get.team))
    figure

  override def handle(state: GameState): Option[ProgrammState] =
    val board: Board = state.board.foreach(state.team, reset)
    Some(new GameState(state.team, board))
}
