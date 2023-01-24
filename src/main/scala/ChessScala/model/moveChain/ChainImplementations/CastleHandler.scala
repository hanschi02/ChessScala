package ChessScala.model.moveChain.ChainImplementations

import ChessScala.model.board.{Board, Coordinate}
import ChessScala.model.figureStrategies.figureDecorators.{CastleRook, EnPassantPawn}
import ChessScala.model.figureStrategies.strategyImplementations.*
import ChessScala.model.figureStrategies.{Figure, White}
import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.GameState
import ChessScala.model.moveChain.{GameChain, Move}
import ChessScala.model.moveChain.ChainImplementations.CheckHandler
import com.google.inject.internal.InternalFlags.ColorizeOption

class CastleHandler(move: Move) extends GameChain {
  override val next: GameChain = new CheckHandler(move.target)

  override def handle(state: GameState): Option[ProgrammState] =
    if (!state.board.get(move.target).get.isInstanceOf[King]) next.handle(state)
    else moveKing(state) match
      case Some(value) => next.handle(value.asInstanceOf[GameState])
      case None => None


  def moveKing(state: GameState): Option[ProgrammState] =
    val king = if (state.team == White) WhiteKing else BlackKing
    if (move.start != king.startField) return Some(resetRooks(state))
    if (!king.castleFields.contains(move.target)) return Some(resetRooks(state))
    castle(state)


  def resetRooks(state: GameState): GameState =
    val board: Board = state.board.foreach(state.team, reset)
    new GameState(state.team, board)

  def reset(figure: Option[Figure]) : Option[Figure] =
    if (figure.get.isInstanceOf[CastleRook]) return Some(new Rook(figure.get.team))
    figure

  def castle(state: GameState): Option[ProgrammState] =
    val newState = if (state.team == White) whiteCastle(state) else blackCastle(state)
    if (newState.isEmpty) None else Some(newState.get)

  def whiteCastle(state: GameState): Option[GameState] =
    println(move.target)
    if (move.target == Coordinate(6,0)) return smallWhiteCastle(state)
    if (move.target == Coordinate(2,0)) return bigWhiteCastle(state)
    None

  def blackCastle(state: GameState): Option[GameState] =
    if (move.target == Coordinate(6,7)) return smallBlackCastle(state)
    if (move.target == Coordinate(2,7)) return bigBlackCastle(state)
    None

  def smallWhiteCastle(state: GameState): Option[GameState] =
    if (state.board.get(Coordinate(7,0)).isEmpty) return None
    if (!state.board.get(Coordinate(7,0)).get.isInstanceOf[CastleRook]) return None
    if (state.board.is_attacked(Coordinate(5,0), state.team)) return None
    if (state.board.is_attacked(Coordinate(6,0), state.team)) return None
    if (state.board.is_occupied(Coordinate(5,0))) return None
    var board = state.board.delete(Coordinate(4,0))
    board = board.insert(Coordinate(6,0), WhiteKing)
    board = board.insert(Coordinate(5,0), board.get(Coordinate(7,0)).get.get)
    board = board.delete(Coordinate(7,0))
    Some(resetRooks(new GameState(state.team, board)))


  def smallBlackCastle(state: GameState): Option[GameState] =
    if (state.board.get(Coordinate(7,7)).isEmpty) return None
    if (!state.board.get(Coordinate(7,7)).get.isInstanceOf[CastleRook]) return None
    if (state.board.is_attacked(Coordinate(5,7), state.team)) return None
    if (state.board.is_attacked(Coordinate(6,7), state.team)) return None
    if (state.board.is_occupied(Coordinate(5,7))) return None
    var board = state.board.delete(Coordinate(4,7))
    board = board.insert(Coordinate(6,7), BlackKing)
    board = board.insert(Coordinate(5,7), board.get(Coordinate(7,7)).get.get)
    board = board.delete(Coordinate(7,7))
    Some(resetRooks(new GameState(state.team, board)))

  def bigWhiteCastle(state: GameState): Option[GameState] =
    if (state.board.get(Coordinate(0,0)).isEmpty) return None
    if (!state.board.get(Coordinate(0,0)).get.isInstanceOf[CastleRook]) return None
    if (state.board.is_attacked(Coordinate(2,0), state.team)) return None
    if (state.board.is_attacked(Coordinate(3,0), state.team)) return None
    if (state.board.is_occupied(Coordinate(3,0))) return None
    var board = state.board.delete(Coordinate(4,0))
    board = board.insert(Coordinate(2,0), WhiteKing)
    board = board.insert(Coordinate(3,0), board.get(Coordinate(7,0)).get.get)
    board = board.delete(Coordinate(0,0))
    Some(resetRooks(new GameState(state.team, board)))


  def bigBlackCastle(state: GameState): Option[GameState] =
    if (state.board.get(Coordinate(0,7)).isEmpty) return None
    if (!state.board.get(Coordinate(0,7)).get.isInstanceOf[CastleRook]) return None
    if (state.board.is_attacked(Coordinate(2,7), state.team)) return None
    if (state.board.is_attacked(Coordinate(3,7), state.team)) return None
    if (state.board.is_occupied(Coordinate(3,7))) return None
    var board = state.board.delete(Coordinate(4,7))
    board = board.insert(Coordinate(2,7), BlackKing)
    board = board.insert(Coordinate(3,7), board.get(Coordinate(7,7)).get.get)
    board = board.delete(Coordinate(0,7))
    Some(resetRooks(new GameState(state.team, board)))
}