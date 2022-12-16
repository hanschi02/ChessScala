package ChessScala.model.gameState

import ChessScala.model.gameState.ProgrammState
import ChessScala.model.gameState.stateImplementation.MenuState

def newState(): ProgrammState = new MenuState()
