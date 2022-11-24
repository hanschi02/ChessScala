package ChessScala.model.gameState

import ChessScala.model.board.Board
import ChessScala.model.interpreter.Interpreter

trait ProgrammState {
 
 val interpreter : Interpreter
 def handle(input:String): (ProgrammState, String) 
}
