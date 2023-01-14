package ChessScala.controller

import ChessScala.model.gameState.ProgrammState
import ChessScala.util.Observable

trait IController extends Observable{

  var output: String

  var state: ProgrammState

  def printDescriptor() : Unit

  def computeInput(input: String) : Unit

}