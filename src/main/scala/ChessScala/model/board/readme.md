# ChessScala.model.board

This package contains the classes that are used to model the chess board and the chess pieces on it. The package contains the following classes:

## Coordinate
A case class that represents a coordinate on the chess board. It has two fields, "x" and "y", both of which are integers.

## Board
A class that represents the state of the chess board. It has a single field, "map", which is a Map of Coordinate to Option[Figure], representing the current state of the chess board. The class has several methods:
- insert(coordinate: Coordinate, figure: Option[Figure]) : This method takes a Coordinate and an Option[Figure] as input and returns a new Board object with the specified figure inserted at the specified coordinate on the map.
- insert(coordinate: Coordinate, figure: Figure) : This method takes a Coordinate and a Figure as input and returns a new Board object with the specified figure inserted at the specified coordinate on the map.
- delete(coordinate: Coordinate) : This method takes a Coordinate as input and returns a new Board object with the figure at the specified coordinate removed from the map.
- get(coordinate: Coordinate): Option[Figure] : This method takes a Coordinate as input and returns the Figure at that coordinate on the map, or None if the coordinate is empty.
- is_on_board(x: Coordinate): Boolean : This method takes a Coordinate as input and returns a Boolean indicating whether the coordinate is within the boundaries of the chess board.
- is_occupied(c: Coordinate): Boolean : This method takes a Coordinate as input and returns a Boolean indicating whether the coordinate is occupied by a figure on the chess board.
- is_free(c: Coordinate): Boolean : This method takes a Coordinate as input and returns a Boolean indicating whether the coordinate is free on the chess board.
- is_attacked(c: Coordinate, team: Team): Boolean : This method takes a Coordinate and a team as input and returns a Boolean indicating whether the coordinate is attacked by the opposite team on the chess board.
- foreach(team: Team, func: Option[Figure] => Option[Figure]): Board : This method takes a team and a function as input and applies the function to all figures of the given team on the chess board, and returns a new Board object.

## BoardBuilder
A class that helps creating a chess board. It has a single field, "size", which is an integer that represents the size of the chess board. The class has several methods:
- createEmptyBoard() : This method creates and returns a new empty board.
- createChessBoard() : This method creates and returns a new chess board with all the chess pieces set in their initial positions.
- insertPawn(board : Board, team: Team, i : Int = 0) : This method inserts pawns on the board.
- insertPawns(board : Board) : This method inserts pawns of both teams on the board.
