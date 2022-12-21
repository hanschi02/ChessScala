package ChessScala

import ChessScala.controller._
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule


class ChessModule extends AbstractModule with ScalaModule {

  def configure() =
    {
      bind[IController].to[Controller]
    }

}
