package ChessScala.model.moveChain

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{Black, BlackKing, King, Team, White, WhiteKing}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.moveChain.checkBridge.ConcreteCheckBridge

class CheckHandler() extends GameChain {
  override val next: GameChain = new SwitchHandler

  override def handle(state: GameState): Option[ProgrammState] =
    isCheck(state.team, state.board) match
      case true => None
      case false => next.handle(state)

  def isCheck(team: Team, board: Board): Boolean = (new ConcreteCheckBridge).isCheck(team, board)




}
