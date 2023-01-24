package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.{Figure, Team, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.moveChain.{GameChain, Move}

import scala.util.{Failure, Success, Try}

class MoveHandler(move: Move) extends GameChain {
  override val next: GameChain = new CastleHandler(move)

  override def handle(state: GameState): Option[ProgrammState] =
    val result = Try[Board]{mover(state).get}
    result match
      case Failure(_) => None
      case Success(value : Board) => next.handle((new GameState(state.team, value)))


  def mover(state: GameState): Option[Board] =
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
