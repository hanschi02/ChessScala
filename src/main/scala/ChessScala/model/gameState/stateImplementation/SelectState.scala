package ChessScala.model.gameState.stateImplementation

import ChessScala.model.board.*
import ChessScala.model.factory.*
import ChessScala.model.figureStrategies.{Black, Team, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.interpreter.{Interpreter, SelectInterpreter}


class SelectState(team: Team, coordinate: Coordinate, override val board: Board) extends ProgrammState {

  override val interpreter : Interpreter = new SelectInterpreter
  val factory : Factory = new FigureFactory(team)
  val nextTeam : Team = if (team == White) Black else White

  override def handle(input: String): (ProgrammState, String) =

    val (output, result) = interpreter.processInputLine(input)

    result match
      case false => (this, output)
      case true => {

        val figure = factory.createFigure(input)
        val newBoard : Board = board.insert(coordinate, figure)
        (new GameState(nextTeam, newBoard), output)


      }

}
