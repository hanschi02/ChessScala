package ChessScala.model.figureStrategies

import ChessScala.model.board.{Board, Coordinate}


class Knight(override val team: Team) extends Figure(team) {

  private val possibleMoves = Vector((1,2),(1,-2),(-1,2),(-1,-2),(2,1),(-2,1),(2,-1),(-2,-1))

  override def getAttacks(position : Coordinate, board : Board): Vector[Coordinate] = Vector()
  
  override def getMotion(position : Coordinate, board : Board): Vector[Coordinate] = Vector()
    


}
