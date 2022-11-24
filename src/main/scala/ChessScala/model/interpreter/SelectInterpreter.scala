package ChessScala.model.interpreter

import ChessScala.model.figureStrategies.Team

class SelectInterpreter extends Interpreter {

  override val descriptor: String = "Select a figure"

  def selectFigure(figure : String): (String, Boolean) =

    figure.toLowerCase() match
      case "queen" => ("Queen selected", true)
      case "knight" => ("Knight selected", true)
      case "rook" => ("Rook selected", true)
      case "bishop" => ("Bishop selected", true)
      case _ => ("Non eligibale figure", false)


  val actions: Map[String, String => (String, Boolean)] = Map((".*", selectFigure))


}
