import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestEight {
  def request = http("request_8")
    .get("/computers?p=4")

}
