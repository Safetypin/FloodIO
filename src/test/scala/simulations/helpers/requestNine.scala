import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestNine {
  def request = http("request_9")
    .get("/computers/new")

}
