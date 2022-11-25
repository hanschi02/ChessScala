package ChessScala.model.board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.model.board.Coordinate

class BoardBuilderSpec extends AnyWordSpec with Matchers {

  "The BoardBuilder" should {

    "create an empty board" in {

      val boardBuilder : BoardBuilder = new BoardBuilder(2)

      val board : Board = boardBuilder.createEmptyBoard()

      val keys = board.map.keys

      keys should contain (Coordinate(0, 0))

    }

  }

}
