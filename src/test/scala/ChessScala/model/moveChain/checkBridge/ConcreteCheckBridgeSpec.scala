package ChessScala.model.moveChain.checkBridge

import ChessScala.model.board.{BoardBuilder, Coordinate}
import ChessScala.model.figureStrategies.*
import ChessScala.model.figureStrategies.strategyImplementations.{Queen, WhiteKing}
import ChessScala.model.interpreter.Interpreter
import ChessScala.model.interpreter.interpreterImplementations.GameInterpreter
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ConcreteCheckBridgeSpec extends AnyWordSpec with Matchers {

  "The CheckBridge should" should {
    "return if it is check" in {
      val builder = new BoardBuilder(8)
        var king = Coordinate(0, 0)
        var enemy = Coordinate(1, 1)
        var queen = new Queen(Black)
        var board = builder.createEmptyBoard().insert(king, WhiteKing).insert(enemy, queen)
        var check = new ConcreteCheckBridge
        check.isCheck(White, board) should be (true)

       king = Coordinate(4, 7)
       enemy = Coordinate(7, 4)
       board = builder.createEmptyBoard().insert(king, WhiteKing).insert(enemy, queen)
       check = new ConcreteCheckBridge
      //check.isCheck(White, board) should be (true)

    }
  }
}