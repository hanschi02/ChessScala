package ChessScala.model.gameState

import ChessScala.model.figureStrategies.Team

import ChessScala.model.board.Board

import ChessScala.model.interpreter.{GameInterpreter, Interpreter}

class GameState(team: Team, board: Board) extends ProgrammState {

  override val interpreter : Interpreter = new GameInterpreter

  override def handle(input: String): (ProgrammState, String) =
    (this, "")  

}
