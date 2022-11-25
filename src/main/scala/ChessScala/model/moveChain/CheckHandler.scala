package ChessScala.model.moveChain

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{Black, BlackKing, King, Team, White, WhiteKing}
import ChessScala.model.gameState.{GameState, ProgrammState}
import ChessScala.model.moveChain.checkBridge.ConcreteCheckBridge

class CheckHandler(team: Team) extends GameChain {

  val enemyTeam: Team = if (team == White) Black else White
  val king: King = if (team == White) WhiteKing else BlackKing

  override val next: GameChain = new MateHandler(team)

  override def handle(state: GameState): Option[ProgrammState] =
    isCheck(state.team, state.board) match
      case false => None
      case true => next.handle(state)

  def isCheck(team: Team, board: Board): Boolean = (new ConcreteCheckBridge).isCheck(team, board)




}
