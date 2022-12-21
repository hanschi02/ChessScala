package ChessScala.controller

trait IController {

  def printDescriptor() : Unit

  def computeInput(input: String) : Unit

}
