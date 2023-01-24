# Interpreter
The `Interpreter` trait defines the basic structure of an interpreter. It provides an `actions` map, which contains the possible inputs and the corresponding functions to handle them. It also has a `descriptor` field, which is a string that describes the expected input.

The `processInputLine` method is the main method of the interpreter. It takes an input string as a parameter and returns a tuple of the form (output: String, success: Boolean). The output is a string that describes the result of the input, and the success is a boolean that indicates whether the input was valid or not.

The `selectRegEx` method is a helper method that is used by the `processInputLine` method. It takes an input string as a parameter and returns the function from the `actions` map that corresponds to the input.

