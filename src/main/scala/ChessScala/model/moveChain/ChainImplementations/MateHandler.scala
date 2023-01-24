package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.strategyImplementations.{BlackKing, WhiteKing}
import ChessScala.model.figureStrategies.{Black, Figure, Team, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.{GameState, MateState}
import ChessScala.model.moveChain.checkBridge.ConcreteCheckBridge
import ChessScala.model.moveChain.GameChain

class MateHandler() extends GameChain {

  override val next: GameChain = new SwitchHandler

  override def handle(state: GameState): Option[ProgrammState] =
    val enemy: Team = if (state.team == White) Black else White
    val winner: String = if (state.team == White) "White" else "Black"
    if (isMate(enemy,state.board)) return Some(new MateState("Checkmate, " + winner + " wins!", state.board))
    if (isStaleMate(enemy,state.board)) return Some(new MateState("Stalemate, draw!", state.board))
    next.handle(state)

  def isCheck(team: Team, board: Board): Boolean = (new ConcreteCheckBridge).isCheck(team, board)

  def isMate(team: Team, board: Board):Boolean =
    if (!isCheck(team, board)) return false
    val moves = allMoves(team, board)
    moves.forall(k=> isCheck(team,k))


  def allMoves(team: Team, board: Board): Vector[Board] =
    val figures = board.map.filter(_._2.isDefined).map(k=> (k._1,k._2.get))
      .filter(_._2.team == team)
      .toVector
    val moves = figures.map(k=> (k,k._2.getMoves(k._1,board)))
    return moves.flatMap(k=> k._2.map(j=> k._1._2.move(k._1._1,j,board)))

  def isStaleMate(team: Team,board: Board): Boolean =
    val moves = allMoves(team, board)
    moves.forall(k=> isCheck(team,k))

}
