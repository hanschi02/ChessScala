package ChessScala
import scala.io.StdIn

object MainClass {

  @main def main():Unit =
    val tui = new TUI
    while(true){
      tui.readLine()
    }
}