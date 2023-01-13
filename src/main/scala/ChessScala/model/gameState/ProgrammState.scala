package ChessScala.model.gameState

import ChessScala.ChessModule
import ChessScala.model.board.Board
import ChessScala.model.fileIO.FileIOInterface
import ChessScala.model.interpreter.Interpreter
import com.google.inject.name.Names
import com.google.inject.{Guice, Inject, Injector}
import net.codingwell.scalaguice.InjectorExtensions.*

import javax.imageio.stream.FileCacheImageOutputStream

trait ProgrammState @Inject{
 
 val interpreter : Interpreter
 val board : Board

 val injector: Injector = Guice.createInjector(new ChessModule)
 var fileIO: FileIOInterface = injector.getInstance(classOf[FileIOInterface])
 def handle(input:String): (ProgrammState, String) 
}
