package ChessScala.model.factory.factoryImplementation

import ChessScala.model.factory.Factory
import ChessScala.model.figureStrategies.*
import ChessScala.model.figureStrategies.figureDecorators.{CastleRook, EnPassantPawn, GroundPawn}
import ChessScala.model.figureStrategies.strategyImplementations.{Bishop, BlackKing, Knight, Pawn, Queen, Rook, WhiteKing}

class IdFactory extends Factory {

  override def createFigure(figure : String) : Figure =
    figure.toInt match
      case 1 => new Rook(Black) // blackRook
      case 2 => new Knight(Black) // blackKnight
      case 3 => new Bishop(Black) // blackBishop
      case 4 => new Queen(Black) // blackQueen
      case 5 => BlackKing // blackKing
      case 6 => new Pawn(Black) // blackPawn
      case 7 => new Rook(White) // whiteRook
      case 8 => new Knight(White) // whiteKnight
      case 9 => new Bishop(White) // whiteBishop
      case 10 => new Queen(White) // whiteQueen
      case 11 => WhiteKing // whiteKing
      case 12 => new Pawn(White) // whitePawn
      case 13 => new GroundPawn(Black)
      case 14 => new GroundPawn(White)
      case 15 => new EnPassantPawn(Black)
      case 16 => new EnPassantPawn(White)
      case 17 => new CastleRook(Black)
      case 18 => new CastleRook(White)


}
