package ChessScala.model.moveChain
import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.{Figure, Team, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState


import scala.util.{Failure, Success, Try}

class MoveHandler(move: Move) extends GameChain {
  override val next: GameChain = new CheckHandler()

  override def handle(state: GameState): Option[ProgrammState] =
    val result = Try[Board]{mover(move, state).get}
    result match
      case Failure(_) => None
      case Success(value : Board) => next.handle((new GameState(state.team, value)))


  def mover(move: Move, state: GameState): Option[Board] =
    //Some(board.insert(move.target, board.get(move.start)).delete(move.start))
    val success = Try[Figure] {state.board.get(move.start).get}
    success match
      case Failure(_) => None
      case Success(value) => {
        if (value.team != state.team) return None
        val vector = value.getMoves(move.start, state.board)
        if (!vector.contains(move.target)) return None
        Some(value.move(move.start, move.target, state.board))
      }

}
