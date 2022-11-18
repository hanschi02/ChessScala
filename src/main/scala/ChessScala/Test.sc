
var vector = Vector(1, 2, 3)

var vector2 = vector.flatMap(k => vector.map(j => (k,j)))

