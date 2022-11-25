package ChessScala.model.factory
import ChessScala.model.figureStrategies._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class FigureFactorySpec extends AnyWordSpec with Matchers {

  val figureFactory = new FigureFactory(White)

  "A Figure factory " should {

    "create a Bishop" in {

      val bishop : String = "Bishop"

      val figure = figureFactory.createFigure(bishop)

      figure.isInstanceOf[Bishop] should be (true)

    }

    "create a Rook" in {

      val rook: String = "Rook"

      val figure = figureFactory.createFigure(rook)

      figure.isInstanceOf[Rook] should be(true)

    }

    "create a Knight" in {

      val knight: String = "Knight"

      val figure = figureFactory.createFigure(knight)

      figure.isInstanceOf[Knight] should be(true)

    }

    "create a Queen" in {

      val queen: String = "queen"

      val figure = figureFactory.createFigure(queen)

      figure.isInstanceOf[Queen] should be(true)

    }


  }



}
