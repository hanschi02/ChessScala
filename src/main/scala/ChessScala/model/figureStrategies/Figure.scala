package ChessScala.model.figureStrategies
import ChessScala.model.board.{Board, Coordinate}

trait Figure(val team : Team) {

  protected def getMotion(position : Coordinate, board : Board): Vector[Coordinate]

  protected def getAttacks(position: Coordinate, board : Board): Vector[Coordinate]

  def getMoves(position : Coordinate, board: Board): Vector[Coordinate] =
      getMotion(position, board).appendedAll(getAttacks(position, board))

  def move(start: Coordinate, target: Coordinate, board: Board) : Board =
    board.delete(start).insert(target,this.get)

  val get: Figure = this
  val id : Int 

}
