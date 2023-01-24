package ChessScala.model.gameState.stateImplementation

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.Team
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.interpreter.Interpreter
import ChessScala.model.interpreter.interpreterImplementations.GameInterpreter
import ChessScala.model.moveChain.ChainImplementations.MoveHandler
import ChessScala.model.moveChain.{GameChain, MoveDecoder}

import scala.util.{Failure, Success, Try}


class GameState(val team: Team, override val board: Board) extends ProgrammState {


  override val interpreter : Interpreter = new GameInterpreter


  override def handle(input: String): (ProgrammState, String) =
    if (input.length != 4) return (this, "Wrong move. Please try again.")
    if (input == "save") {
      fileIO.save(this)
      return (this, "Game saved")
    } else if (input == "load") {
      return (fileIO.load("Chess"), "Game loaded")
    }
    val result = interpreter.processInputLine(input)
    val chain : GameChain = new MoveHandler(MoveDecoder.decode(input))
    val success = Try{chain.handle(this).get}
    success match
    case Failure(_) => return (this, "Wrong move. Please try again.")
    case Success(value) => {
      value match
        case _: MateState => (value, value.asInstanceOf[MateState].result)
        case _ => (value, result._1)
    }
}
