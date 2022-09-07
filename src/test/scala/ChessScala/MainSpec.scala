package ChessScala

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MainSpec extends AnyWordSpec with Matchers{

  val border: String = MainClass.drawBorder(1)
  val line: String = MainClass.drawLine(1)
  val field: String = MainClass.drawField(1)

  "The main class " should {
    "draw the border of the chess board " in {
      border should be ("-" * 8 + "\n")
    }

    "draw a line of the chess board " in {
      line should be ( border + "|" + " " * 8 + "\n")
    }

    "draw a chess board" in {
      field should be (line + border)
    }
  }
}

