package ChessScala.model.gameState

import ChessScala.model.figureStrategies.Team
import ChessScala.model.board.Board
import ChessScala.model.interpreter.{GameInterpreter, Interpreter}
import ChessScala.model.moveChain.{GameChain, MoveDecoder, MoveHandler}
import scala.util.{Failure, Success, Try}

class GameState(override val team: Team, override val board: Board) extends ProgrammState {

  override val interpreter : Interpreter = new GameInterpreter


  override def handle(input: String): (ProgrammState, String) =
    val result = interpreter.processInputLine(input)
    if (!result._2) return (this, result._1)
    val chain : GameChain = new MoveHandler(MoveDecoder.decode(input))
    val success = Try{chain.handle(this).get}
    success match
      case Failure(_) => return (this, "Wrong move. Please try again.")
      case Success(value) => (value, result._1)

}
