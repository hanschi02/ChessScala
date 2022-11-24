package ChessScala.model.gameState

import ChessScala.model.board.Board

trait ProgrammState{
 
 def handle(input:String):ProgrammState 
}