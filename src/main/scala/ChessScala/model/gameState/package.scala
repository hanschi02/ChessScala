package ChessScala.model

package object gameState {

  def newState(): ProgrammState = new MenuState()
}
