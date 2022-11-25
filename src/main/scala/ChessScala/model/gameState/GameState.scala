package ChessScala.model.gameState

import ChessScala.model.figureStrategies.Team
import ChessScala.model.board.Board
import ChessScala.model.interpreter.{GameInterpreter, Interpreter}
import ChessScala.model.moveChain.{GameChain, Move, MoveDecoder, MoveHandler}

import scala.util.{Failure, Success, Try}

class GameState(val team: Team, val board: Board) extends ProgrammState {

  override val interpreter : Interpreter = new GameInterpreter

  override def handle(input: String): (ProgrammState, String) =
    val interpreterResult = interpreter.processInputLine(input)
    return (this, interpreterResult._1)
    if (!interpreterResult._2) {return (this, interpreterResult._1)}
    val move: Move = MoveDecoder.decode(input)
    val handler: GameChain = new MoveHandler(move)
    val handlerResult = Try[ProgrammState]{handler.handle(this).get}
    handlerResult match
      case Failure(exception) => (this, "move not possible")
      case Success(value) => (value, interpreterResult._1)
}
