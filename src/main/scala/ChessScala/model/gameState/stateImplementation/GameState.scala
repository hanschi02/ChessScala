package ChessScala.model.gameState.stateImplementation

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.Team
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.interpreter.{GameInterpreter, Interpreter}
import ChessScala.model.moveChain.{GameChain, MoveDecoder, MoveHandler}


class GameState(val team: Team, override val board: Board) extends ProgrammState {

  override val interpreter : Interpreter = new GameInterpreter


  override def handle(input: String): (ProgrammState, String) =
    val result = interpreter.processInputLine(input)
    if (input == "save") {
      fileIO.save(this)
      return (this, "Game saved")
    } else if (input == "load") {
      return (fileIO.load(), "Game loaded")
    }
    val chain : GameChain = new MoveHandler(MoveDecoder.decode(input))
    (chain.handle(this).get, result._1)

}
