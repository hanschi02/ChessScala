package ChessScala.model

trait Interpreter {

  val actions: Map[String, String => (String, Interpreter)]

  val descriptor: String

  final def selectRegEx(input: String): String => (String, Interpreter) =
    actions.filter(k => input.matches(k._1)).last._2

  final def processInputLine(input: String): (String, Interpreter) = selectRegEx(input)(input)
}
