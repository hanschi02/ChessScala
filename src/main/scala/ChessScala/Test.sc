import ChessScala.model.figureStrategies.{Bishop, White}

val bishop : Bishop = new Bishop(White)
var vector = Vector(1, 2, 3)

var vector2 = vector.flatMap(k => vector.map(j => (k,j)))

