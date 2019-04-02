import cats.effect._
import cats.implicits._
import fs2.{Stream, StreamApp}
import fs2.StreamApp.ExitCode
import org.http4s.HttpService
import org.http4s.dsl.io._
import org.http4s.server.blaze._
import org.http4s.implicits._
import org.http4s.server.blaze._
import org.http4s.syntax._
import services.TodoService
import scala.concurrent.ExecutionContext.Implicits.global


object Main extends StreamApp[IO]{

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "localhost")
      .mountService(TodoService.todoService, "/")
      .serve
}