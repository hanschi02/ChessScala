package ChessScala.model.gameState

import ChessScala.model.board.{Board, BoardBuilder}
import ChessScala.model.figureStrategies.White
import ChessScala.model.interpreter.{GameInterpreter, Interpreter, MenuInterpreter}

class MenuState extends ProgrammState {

  override val interpreter : Interpreter = new MenuInterpreter
  val builder : BoardBuilder = new BoardBuilder(8)
  override val board: Board = builder.createEmptyBoard()

  override def handle(input: String): (ProgrammState, String) =

    val (output, result) = interpreter.processInputLine(input)

    result match
      case false => (this, output)
      case true => (new GameState(White, builder.createChessBoard()), output)


}
