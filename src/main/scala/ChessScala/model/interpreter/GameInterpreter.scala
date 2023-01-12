package ChessScala.model.interpreter

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input


class GameInterpreter extends Interpreter {

  override val descriptor: String = "Please enter your Move"

  val move:String = "[a-hA-H][1-8][a-hA-H][1-8]"
  val moveWithSpace: String = "[a-hA-H][1-8] [a-hA-H][1-8]"
  val wrongMove: String = ".*"
  val save: String = "save"
  val load: String = "load"

  def doLoad(input: String): (String, Boolean) = ("load", true)

  def doSave(input : String): (String, Boolean) = ("save", true)

  def doMove(input: String): (String, Boolean) =
    (s"${input(0)}${input(1)} moved to ${input(2)}${input(3)}", true)

  def doMoveWithSpace(input: String): (String, Boolean) =
    (f"${input(0)}${input(1)} moved to ${input(3)}${input(4)}", true)

  def doWrongMove(input:String): (String, Boolean) =
    ("Wrong move. Please try again.",false)

  override val actions: Map[String, String => (String, Boolean)] =
    Map((wrongMove, doWrongMove), (move,doMove), (moveWithSpace, doMoveWithSpace), (save, doSave), (load, doLoad))
}