package ChessScala.model.interpreter.interpreterImplementations

import ChessScala.model.interpreter.Interpreter

class MenuInterpreter extends Interpreter {

  override val descriptor: String = "Please enter 1 for a new game"

  val newGame: String = "1"
  val wrongInput: String = ".*"

  def doNewGame(input: String): (String, Boolean) = ("", true)

  def doWrongInput(input: String): (String, Boolean) = ("Wrong input. Please try again.", false)

  override val actions: Map[String, String => (String, Boolean)] =
    Map((wrongInput, doWrongInput),(newGame,doNewGame))
}