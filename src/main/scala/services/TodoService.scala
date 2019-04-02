package services

import cats.effect.IO
import org.http4s.HttpService
import org.http4s.dsl.io._

object TodoService {
  val todoService = HttpService[IO]{
    case GET -> Root / "hello" / name => Ok(s"Hello, $name.")
  }
}
