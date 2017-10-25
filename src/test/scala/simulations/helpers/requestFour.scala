import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestFour {
  def request = http("request_4")
    .get("/")

}
