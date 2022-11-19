package ChessScala.model.figureStrategies.figureBridge
import ChessScala.model.board.{Coordinate, Board}

trait FigureBridge {

  val bishopDirections: Vector[Coordinate]
  val rookDirections: Vector[Coordinate]


  def getMotion(board: Board, place: Coordinate, target: Coordinate): Vector[Coordinate]

  def getAttacks(board: Board, place: Coordinate, target: Coordinate): Vector[Coordinate]

}
