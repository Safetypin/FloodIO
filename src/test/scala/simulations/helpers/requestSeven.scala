import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestSeven {
  def request = http("request_7")
    .get("/computers?p=3")

}
