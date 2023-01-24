# ProgramState
The `ProgramState` trait defines the state of the program and the behavior of the program at a certain point in time.

## Properties
- `interpreter` : an instance of the `Interpreter` trait, responsible for processing user input
- `board` : an instance of the `Board` class, representing the current state of the chess board
- `fileIO` : an instance of the `FileIOInterface` that handle saving and loading the game state
- `injector` : an instance of the `Injector` class from Google Guice, responsible for dependency injection

## Methods
- `handle(input:String): (ProgrammState, String)`: This method is responsible for handling the user input and returning a new `ProgramState` and a string indicating the status of the game. The input is passed as a parameter to the method.

## Usage
The `ProgramState` trait is meant to be extended by concrete state classes that implement the `handle` method and define the behavior of the program in that state. Examples of such classes include the `MenuState`, `GameState`, and `MateState`. The `ProgramState` trait is used to define the state of the program and the behavior of the program at a certain point in time.
