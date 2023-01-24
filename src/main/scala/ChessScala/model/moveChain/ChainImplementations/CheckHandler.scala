package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.strategyImplementations.{BlackKing, King, WhiteKing}
import ChessScala.model.figureStrategies.{Black, Team, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.moveChain.checkBridge.ConcreteCheckBridge
import ChessScala.model.moveChain.GameChain

class CheckHandler(coordinate: Coordinate) extends GameChain {
  override val next: GameChain = new PromoteHandler(coordinate)

  override def handle(state: GameState): Option[ProgrammState] =
    isCheck(state.team, state.board) match
      case true => None
      case false => next.handle(state)

  def isCheck(team: Team, board: Board): Boolean = (new ConcreteCheckBridge).isCheck(team, board)




}
