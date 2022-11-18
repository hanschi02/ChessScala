package ChessScala.model.interpreter

import ChessScala.model.interpreter.{GameInterpreter, Interpreter}

class MenuInterpreter extends Interpreter {

  override val descriptor: String = "Please enter 1 for a new game"

  val newGame: String = "1"
  val wrongInput: String = ".*"

  def doNewGame(input: String): (String, GameInterpreter) = ("",new GameInterpreter)

  def doWrongInput(input: String): (String, MenuInterpreter) = ("Wrong input. Please try again.", this)

  override val actions: Map[String, String => (String, Interpreter)] =
    Map((wrongInput, doWrongInput),(newGame,doNewGame))
}