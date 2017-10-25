import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestSix {
  def request = http("request_6")
    .get("/computers?p=2")

}
