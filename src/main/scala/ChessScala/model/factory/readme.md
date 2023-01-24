# ChessScala.model.factory

This package contains the classes that are used to create a chess figures. The package contains the following classes:

## Factory
A trait that represent a factory for creating chess figures, it has a single method "createFigure(figure: String): Figure" which takes a string as input and returns an instance of the `Figure` class or its subclasses.

## FigureFactory
A class that extends the Factory trait, it takes a team as an input and creates a figure from a string input, it can create Bishop, Rook, Knight, Queen figures.

## IdFactory
A class that extends the Factory trait, it creates a figure from an integer input, it can create Rook, Knight, Bishop, Queen, King, Pawn, GroundPawn, EnPassantPawn, CastleRook figures.
