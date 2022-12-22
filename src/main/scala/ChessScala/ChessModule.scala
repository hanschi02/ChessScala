package ChessScala

import ChessScala.controller.*
import ChessScala.model.gameState.stateImplementation.MenuState
import ChessScala.model.gameState.ProgrammState
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import com.google.inject.TypeLiteral


class ChessModule extends AbstractModule {

  override def configure() =
    {
      bind[IController](new TypeLiteral[IController] {}).to(classOf[Controller])
      bind[ProgrammState](new TypeLiteral[ProgrammState] {}).to(classOf[MenuState])
    }

}
