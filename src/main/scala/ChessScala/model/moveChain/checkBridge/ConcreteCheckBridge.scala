package ChessScala.model.moveChain.checkBridge

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.{Black, BlackKing, Team, White, WhiteKing}

class ConcreteCheckBridge extends CheckBridge {

  override def isCheck(team: Team, board: Board): Boolean =
    val king = if (team == Black) BlackKing else WhiteKing
    val kingPosition: Coordinate = board.map.filter(_._2.isDefined).filter(_._2.get == king).last._1
    val enemyTeam: Team = if (team == White) Black else White
    board.map.filter(_._2.isDefined)
      .filter(_._2.get.team == enemyTeam)
      .flatMap(k => k._2.get.getMoves(k._1,board))
      .toVector
      .contains(kingPosition)

}
