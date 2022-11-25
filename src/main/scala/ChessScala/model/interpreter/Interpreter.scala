package ChessScala.model.interpreter

trait Interpreter {

  val actions: Map[String, String => (String, Boolean)]

  val descriptor: String

  final def selectRegEx(input: String): String => (String, Boolean) =
    actions.filter(k => input.matches(k._1)).last._2

  final def processInputLine(input: String): (String, Boolean) = selectRegEx(input)(input)
}
