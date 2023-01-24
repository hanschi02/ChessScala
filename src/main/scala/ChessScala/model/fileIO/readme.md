# FileIOInterface

The `FileIOInterface` trait defines the methods for saving and loading a `ProgrammState` to and from a file.

## Methods

### save(state: ProgrammState)

This method takes a `ProgrammState` as its parameter and saves it to a file.

### load(path: String) : ProgrammState

This method takes a string as its parameter, which represents the path of the file, and returns a `ProgrammState` loaded from the file at the given path.

