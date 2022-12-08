package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}

trait Figure(val team : Team) {

  protected def getMotion(position : Coordinate, board : Board): Vector[Coordinate]

  protected def getAttacks(position: Coordinate, board : Board): Vector[Coordinate]

  def getMoves(position : Coordinate, board: Board): Vector[Coordinate] =
      getMotion(position, board).appendedAll(getAttacks(position, board))
      
  val get: Figure = this
  val id : Int 

}
