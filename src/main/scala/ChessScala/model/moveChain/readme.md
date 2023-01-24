# GameChain

GameChain is a trait that represents a chain of actions that happen during a game of chess. The trait defines a single abstract method, `handle`, which takes a `GameState` and returns an `Option[ProgrammState]`. The `handle` method is responsible for performing a specific action on the `GameState`, and then passing the updated state to the next link in the chain.

The `GameChain` trait also defines a field `next: GameChain`, which represents the next link in the chain. The `next` field is initialized in the constructor of each `GameChain` subclass, and is used in the `handle` method to pass the updated state to the next link in the chain.

The `GameChain` trait is implemented by several subclasses, each of which represents a specific action that can be performed during a game of chess. These subclasses include:

- `MoveHandler`: Handles a move made by a player.
- `CastleHandler`: Handles a castle move made by a player.
- `CheckHandler`: Handles a check or checkmate situation.
- `PromoteHandler`: Handles the promotion of a pawn.
- `MateHandler`: Handles a checkmate situation.
- `SwitchHandler`: Switch the current team.
- `ResetHandler`: reset the board state.

Each link in the chain calls the `handle` method of the next link in the chain, passing it the updated state. The final link in the chain is responsible for returning the updated state to the calling function.

The `GameChain` is used to implement the game logic of chess, and is responsible for performing actions such as moving figures on the board, checking for checkmate or stalemate, and switching the current team.
