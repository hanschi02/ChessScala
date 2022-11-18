package ChessScala.model.board
import ChessScala.model.figureStrategies.Figure

class Board(val map: Map[Coordinate, Option[Figure]])
