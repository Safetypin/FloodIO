import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestTwo {
  def request = http("request_2")
    .get("/computers?f=macbook")
}
