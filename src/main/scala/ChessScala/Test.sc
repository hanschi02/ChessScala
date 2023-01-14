import ChessScala.model.board.BoardBuilder
import ChessScala.model.figureStrategies.White
import ChessScala.model.fileIO.fileIOJson.FileIO
import ChessScala.model.gameState.stateImplementation.GameState

val boardBuilder = new BoardBuilder(8)

val board = boardBuilder.createChessBoard()

val state = new GameState(White, board)

val io = new FileIO

io.gameToJson(state)

