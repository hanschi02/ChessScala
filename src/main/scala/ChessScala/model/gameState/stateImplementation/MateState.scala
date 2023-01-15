package ChessScala.model.gameState.stateImplementation

import ChessScala.model.board.Board
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.interpreter.Interpreter

class MateState(val result: String, override val board: Board) extends ProgrammState{

  val menuState : MenuState = new MenuState
  override val interpreter: Interpreter = menuState.interpreter

  override def handle(input: String): (ProgrammState, String) = menuState.handle(input)


}
