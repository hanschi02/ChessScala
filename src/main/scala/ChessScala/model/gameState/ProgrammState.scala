package ChessScala.model.gameState

import ChessScala.model.board.Board
import ChessScala.model.figureStrategies.Team
import ChessScala.model.interpreter.Interpreter

trait ProgrammState {
 
 val interpreter : Interpreter
 val team: Team
 val board : Board
 def handle(input:String): (ProgrammState, String) 
}
