package ChessScala

class GameInterpreter extends Interpreter {

  override val descriptor: String = "Please enter your Move"

  val move:String = "[a-zA-Z][1-8][a-zA-Z][1-8]"
  val moveWithSpace: String = "[a-zA-Z][1-8] [a-zA-Z][1-8]"
  val wrongMove: String = ".*"

  def doMove(input: String): (String, GameInterpreter) =
    (s"${input(0)}${input(1)} moved to ${input(2)}${input(3)}", this)

  def doMoveWithSpace(input: String): (String, GameInterpreter) =
    (f"${input(0)}${input(1)} moved to ${input(3)}${input(4)}", this)

  def doWrongMove(input:String): (String, GameInterpreter) =
    ("Wrong move. Please try again.",this)

  override val actions: Map[String, String => (String, Interpreter)] =
    Map((wrongMove, doWrongMove), (move,doMove), (moveWithSpace, doMoveWithSpace))
}