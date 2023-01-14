package ChessScala.model.gameState.stateImplementation

import ChessScala.model.board.{Board, BoardBuilder}
import ChessScala.model.figureStrategies.White
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.interpreter.{GameInterpreter, Interpreter, MenuInterpreter}
import com.google.inject.Inject

class MenuState @Inject() extends ProgrammState {

  override val interpreter : Interpreter = new MenuInterpreter

  val builder : BoardBuilder = new BoardBuilder(8)
  override val board: Board = builder.createEmptyBoard()

  override def handle(input: String): (ProgrammState, String) =

    if (input == "load") {
      return (fileIO.load(), "Game loaded")
    }

    val (output, result) = interpreter.processInputLine(input)

    result match
      case false => (this, output)
      case true => (new GameState(White, builder.createChessBoard()), output)


}
