package controller

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import ChessScala.controller.Controller
import ChessScala.model.board.Coordinate
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.{GameState, MenuState}

class ControllerSpec extends AnyWordSpec with Matchers {
  "the Controller" should {

    val controller : Controller = new Controller

    "start as an instance of the main-Menu" in {
      controller.state.isInstanceOf[MenuState] should be (true)
      controller.printDescriptor()
      controller.output should be ("Please enter 1 for a new game")
    }

    "change to the play-mode when the input is 1" in {
      controller.computeInput("1")
      controller.state.isInstanceOf[GameState] should be (true)
    }

    "execute the move e2e4" in {
      controller.state.board.get(Coordinate(4,1)).isDefined should be (true)
      controller.computeInput("e2e4")
      controller.state.board.get(Coordinate(4,3)).isDefined should be (true)
      controller.state.board.get(Coordinate(4,1)).isDefined should be (false)
    }

    "execute the undo-command" in {
      controller.computeInput("undo")
      controller.state.board.get(Coordinate(4,1)).isDefined should be (true)
      controller.state.board.get(Coordinate(4,3)).isDefined should be (false)
    }

    "execute the redo-command" in {
      controller.computeInput("redo")
      controller.state.board.get(Coordinate(4,1)).isDefined should be (false)
      controller.state.board.get(Coordinate(4,3)).isDefined should be (true)
    }

    "not execute a wrong input" in {
      val state: ProgrammState = controller.state
      controller.computeInput("wrong input")
      controller.state should be (state)
      controller.output should be ("Wrong move. Please try again.")
    }

  }

}
