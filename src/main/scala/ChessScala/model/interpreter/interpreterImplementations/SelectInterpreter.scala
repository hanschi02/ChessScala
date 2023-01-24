package ChessScala.model.interpreter.interpreterImplementations

import ChessScala.model.figureStrategies.Team
import ChessScala.model.interpreter.Interpreter

class SelectInterpreter extends Interpreter {

  override val descriptor: String = "Select a figure"

  def selectFigure(figure : String): (String, Boolean) =

    figure.toLowerCase() match
      case "queen" => ("Queen selected", true)
      case "knight" => ("Knight selected", true)
      case "rook" => ("Rook selected", true)
      case "bishop" => ("Bishop selected", true)
      case _ => ("Non eligible figure", false)


  val actions: Map[String, String => (String, Boolean)] = Map((".*", selectFigure))


}
