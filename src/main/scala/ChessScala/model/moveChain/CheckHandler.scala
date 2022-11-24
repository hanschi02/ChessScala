package ChessScala.model.moveChain

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{Black, BlackKing, King, Team, White, WhiteKing}
import ChessScala.model.gameState.{GameState, ProgrammState}

class CheckHandler(team: Team) extends GameChain {

  val enemyTeam: Team = if (team == White) Black else White
  val king: King = if (team == White) WhiteKing else BlackKing

  override val next: GameChain = this

  override def handle(state: GameState): Option[ProgrammState] =
    isCheck(state.team, state.board) match
      case false => None
      case true => next.handle(state)

  def isCheck(team: Team, board: Board): Boolean =
    val kingPosition: Coordinate = board.map.filter(_._2.isDefined).filter(_._2.get == king).last._1
    board.map.filter(_._2.isDefined)
      .filter(_._2.get.team == enemyTeam)
      .flatMap(k => k._2.get.getMoves(k._1,board))
      .toVector
      .contains(kingPosition)




}
