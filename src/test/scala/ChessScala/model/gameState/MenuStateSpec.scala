package ChessScala.model.gameState
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MenuStateSpec extends AnyWordSpec with Matchers {

  val menuState : MenuState = new MenuState

  "A MenuState " should {

    "return a new game " in {

      val result = menuState.handle("1")

      result._1.isInstanceOf[GameState] should be(true)
      result._2 should be("")

    }

    "return an error " in {

      val result = menuState.handle("queen")

      result._1.isInstanceOf[GameState] should be(false)
      result._2 should be("Wrong input. Please try again.")

    }

  }

}
