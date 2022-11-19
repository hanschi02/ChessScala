import ChessScala.model.board.{BoardBuilder, Coordinate}
import ChessScala.model.figureStrategies.{Pawn, Queen, White, WhiteKing}

val builder = new BoardBuilder(8)
val position = Coordinate(0, 0)
val board = builder.createEmptyBoard().insert(position, WhiteKing)


val newBoard = board.insert(Coordinate(2, 2), new Pawn(White))
val queens = newBoard.foreach(White, k=> Some(new Queen(k.get.team)))
queens.get(position).get