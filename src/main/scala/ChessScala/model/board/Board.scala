package ChessScala.model.board

import ChessScala.model.figureStrategies.{Black, Figure, Team, White}

class Board(val map: Map[Coordinate, Option[Figure]]) {

  def insert(coordinate: Coordinate, figure: Option[Figure]): Board = new Board(map + (coordinate -> figure))

  def insert(coordinate: Coordinate, figure: Figure) : Board = insert(coordinate, Some(figure))

  def delete(coordinate: Coordinate) : Board = insert(coordinate, None)

  def get(coordinate: Coordinate): Option[Figure] = map(coordinate)

  def is_on_board(x: Coordinate): Boolean = (x.x min x.y) >= 0 && (x.x max x.y) < 8

  def is_occupied(c: Coordinate): Boolean = is_on_board(c) && get(c).isDefined

  def is_free(c: Coordinate): Boolean = is_on_board(c) && get(c).isEmpty

  def is_attacked(c: Coordinate, team: Team): Boolean =
    this.map.filter(_._2.isDefined)
      .filter(_._2.get.team == (if (team == White) Black else White))
      .flatMap(k => k._2.get.getMoves(k._1,this))
      .toVector
      .contains(c)


  def foreach(team: Team, func: Option[Figure] => Option[Figure]): Board =
    new Board(map.map(k=> if (k._2.isDefined && k._2.get.team == team) (k._1,func(k._2)) else (k._1,k._2)))

}
