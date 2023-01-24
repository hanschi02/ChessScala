package ChessScala.model.gameState.stateImplementation

import ChessScala.model.board.*
import ChessScala.model.factory.*
import ChessScala.model.factory.factoryImplementation.FigureFactory
import ChessScala.model.figureStrategies.{Black, Team, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.interpreter.Interpreter
import ChessScala.model.interpreter.interpreterImplementations.SelectInterpreter
import ChessScala.model.moveChain.ChainImplementations.{CheckHandler, MateHandler, SwitchHandler}
import ChessScala.model.moveChain.GameChain


class SelectState(val team: Team, coordinate: Coordinate, override val board: Board) extends ProgrammState {


  override val interpreter : Interpreter = new SelectInterpreter
  val factory : Factory = new FigureFactory(team)

  override def handle(input: String): (ProgrammState, String) =

    val (output, result) = interpreter.processInputLine(input)

    result match
      case false => (this, output)
      case true => {

        val figure = factory.createFigure(input)
        val newBoard : Board = board.insert(coordinate, figure)
        val handler: GameChain = new MateHandler
        val state: ProgrammState = handler.handle(new GameState(team, newBoard)).get
        (state, output)
      }

}
