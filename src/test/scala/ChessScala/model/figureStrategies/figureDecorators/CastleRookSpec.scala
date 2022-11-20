package ChessScala.model.figureStrategies.figureDecorators
import ChessScala.model.figureStrategies.White
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import ChessScala.model.figureStrategies.Rook

class CastleRookSpec extends AnyWordSpec with Matchers {
  "A castle-rook" should {
    "return a normal rook when he moves" in {
      val rook = new CastleRook(White)
      rook.get.getClass should be ((new Rook(White)).getClass)
    }
  }
}
