package ChessScala.model.fileIO

import ChessScala.model.gameState._

trait FileIOInterface {

  def save(state: ProgrammState) : Unit
  def load(path: String) : ProgrammState

}
