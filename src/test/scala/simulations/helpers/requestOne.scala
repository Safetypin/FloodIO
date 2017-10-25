import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestOne {
  def request = http("request_1")
    .get("/")
}
