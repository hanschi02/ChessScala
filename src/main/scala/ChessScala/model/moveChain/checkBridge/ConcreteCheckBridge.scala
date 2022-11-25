package ChessScala.model.moveChain.checkBridge

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.Team

class ConcreteCheckBridge {

  override def isCheck(team: Team, board: Board): Boolean =
    val kingPosition: Coordinate = board.map.filter(_._2.isDefined).filter(_._2.get == king).last._1
    board.map.filter(_._2.isDefined)
      .filter(_._2.get.team == enemyTeam)
      .flatMap(k => k._2.get.getMoves(k._1,board))
      .toVector
      .contains(kingPosition)

}
