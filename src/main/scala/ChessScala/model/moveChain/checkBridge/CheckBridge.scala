package ChessScala.model.moveChain.checkBridge

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.Team

trait CheckBridge {
  def isCheck(team: Team, board: Board): Boolean
}
