package ChessScala.model.fileIO.fileIOXML

import ChessScala.model.board.{Board, BoardBuilder, Coordinate}
import ChessScala.model.factory.factoryImplementation.IdFactory
import ChessScala.model.figureStrategies.{Black, Figure, Team, White}
import ChessScala.model.fileIO.FileIOInterface
import ChessScala.model.gameState.*
import ChessScala.model.gameState.stateImplementation.{GameState, SelectState}
import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions.*

import scala.util.{Failure, Success, Try}
import scala.xml.{Elem, NodeSeq, PrettyPrinter}

class FileIO extends FileIOInterface {

  override def save(state: ProgrammState): Unit =
    import java.io._
    val pw = new PrintWriter(new File("Chess.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(gameToXML(state))
    pw.write(xml)
    pw.close

  def coordinateToXML(coordinate: Coordinate, board: Board): Elem =
    <coordinate>
      <x>{coordinate.x.toString}</x>
      <y>{coordinate.y.toString}</y>
      <figure>{figureToString(board.get(coordinate))}</figure>
    </coordinate>

  def figureToString(figure: Option[Figure]) : String =
    if (figure.isDefined) figure.get.id.toString
    else "None"

  def boardToXML(board : Board) : Elem =
    <board>{for {field <- board.map} yield coordinateToXML(field._1, board)}</board>

  def gameToXML(state : ProgrammState) : Elem =
    <game>
      <state>{"GameState"}</state>
      <team>{teamToStringGS(state.asInstanceOf[GameState])}</team>
      {boardToXML(state.board)}
    </game>

  def teamToStringGS(state : GameState) : String = if (state.team == White) "White" else "Black"

  override def load(path: String): ProgrammState = {

    val builder = new BoardBuilder(8)
    var board : Board = builder.createEmptyBoard()
    val file = scala.xml.XML.loadFile(path + ".xml")
    val state : String = (file \\ "state").text
    val teamString : String = (file \\ "team").text
    val team: Team = if (teamString == "White") White else Black
    val fields = (file \\ "board" \\ "coordinate")
    for (field <- fields) {
      val x : Int = (field \\ "x").text.toInt
      val y : Int = (field \\ "y").text.toInt

      val coordinate: Coordinate = Coordinate(x, y)
      val id : String = (field \\ "figure").text

      val factory = new IdFactory
      val tryFigure : Try[Figure] = Try {
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
