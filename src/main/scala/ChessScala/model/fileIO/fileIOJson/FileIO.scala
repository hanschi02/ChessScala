package ChessScala.model.fileIO.fileIOJson

import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import ChessScala.model.factory.IdFactory
import ChessScala.model.figureStrategies.{Black, Figure, Team, White}
import ChessScala.model.fileIO.FileIOInterface
import ChessScala.model.gameState.*
import ChessScala.model.gameState.stateImplementation.{GameState, SelectState}
import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions.*

import scala.util.{Failure, Success, Try}
import play.api.libs.json.*

import scala.io.Source

class FileIO extends FileIOInterface {

  override def save(state: ProgrammState): Unit =
    import java.io._
    val pw = new PrintWriter(new File("Chess.json"))
    pw.write(Json.prettyPrint(gameToJson(state)))
    pw.close

  def coordinateToJson(coordinate: Coordinate, board: Board): JsObject =
    Json.obj(
      "coordinate" -> Json.obj(
        "x" -> JsNumber(coordinate.x),
        "y" -> JsNumber(coordinate.y),
        "figure" -> JsString(figureToString(board.get(coordinate)))
      ))

  def figureToString(figure: Option[Figure]): String =
    if (figure.isDefined) figure.get.id.toString
    else "None"


  def gameToJson(state: ProgrammState): JsObject =
    Json.obj(
    "game" -> Json.obj(
      "state" -> JsString("GameState"),
      "team" -> JsString(teamToString(state.asInstanceOf[GameState])),
      "board" -> Json.toJson(for {field <- state.board.map} yield coordinateToJson(field._1, state.board))
    ))

  def teamToString(state: GameState): String = if (state.team == White) "White" else "Black"


  override def load(path: String): ProgrammState = {

    val builder = new BoardBuilder(8)
    var board: Board = builder.createEmptyBoard()
    val file: String = Source.fromFile(path + ".json").getLines().mkString
    val json: JsValue = Json.parse(file)
    val teamString: String = (json \ "game" \ "team").get.toString
    val team: Team = if (teamString == "\"White\"") White else Black
    val fields = (json \ "game" \ "board" \\ "coordinate")
    for (field <- fields) {
      val x: Int = (field \ "x").get.toString.toInt
      val y: Int = (field \ "y").get.toString.toInt

      val coordinate: Coordinate = Coordinate(x, y)
      val id: String = (field \ "figure").get.as[String]

      val factory = new IdFactory
      val tryFigure: Try[Figure] = Try {
        factory.createFigure(id)
      }
      val figure: Option[Figure] = tryFigure match {
        case Success(value) => Some(value)
        case Failure(_) => None
      }
      board = board.insert(coordinate, figure)
    }
    new GameState(team, board)
  }

}
