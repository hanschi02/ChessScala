# figureStrategies

This package contains the classes that define the behavior of the chess pieces on the board. The package contains the following trait:

## Figure
A trait that represents a chess piece. It has two fields, "team" which is an instance of the `Team` class and represents the team the figure belongs to and "id" which is an integer representing the id of the figure.
It has several methods:
- protected def getMotion(position : Coordinate, board : Board): Vector[Coordinate] : This method takes the current position of the figure and the current board as input and returns a Vector of Coordinates representing the possible motion moves of the figure.
- protected def getAttacks(position: Coordinate, board : Board): Vector[Coordinate] : This method takes the current position of the figure and the current board as input and returns a Vector of Coordinates representing the possible attack moves of the figure.
- def getMoves(position : Coordinate, board: Board): Vector[Coordinate] : This method takes the current position of the figure and the current board as input and returns a Vector of Coordinates representing the possible moves of the figure.
- def move(start: Coordinate, target: Coordinate, board: Board) : Board : This method takes the start position of the figure, the target position, and the current board as input and returns a new Board object with the figure moved to the target position.
- val get: Figure = this : This is a getter method that returns the current instance of the figure.
- val id : Int : This is a getter method that returns the id of the figure.

# Usage
The `Figure` trait can be used as a base class for creating different types of chess figures. It provides the basic functionality of getting the possible moves, moving the figure on the board, and getting the team and id of the figure. Subclasses can override the `getMotion` and `getAttacks` methods to define the specific behavior of the figure.
