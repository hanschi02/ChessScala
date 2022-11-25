package ChessScala.model.moveChain

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{BlackKing, Figure, Team, White, WhiteKing}
import ChessScala.model.gameState.{GameState, ProgrammState}
import ChessScala.model.moveChain.checkBridge.ConcreteCheckBridge

class MateHandler(team: Team) extends GameChain {

  val king: Figure = if (team == White) WhiteKing else BlackKing

  override val next: GameChain = this

  override def handle(state: GameState): Option[ProgrammState] = None

  def allMoves(team: Team, board: Board): Vector[Board] = Vector()
 /*   board.map.filter(_._2.isDefined)
      .filter(_._2.get.team == team)
      .flatMap(k=> (k, k._2.get.getMoves(k._1, board)))

*/

  def isCheck(team: Team, board: Board): Boolean = (new ConcreteCheckBridge).isCheck(team, board)

 // def isStaleMate(team: Team,board: Board): Boolean =


}
