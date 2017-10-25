import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestFive {
  def request = http("request_5")
    .get("/computers?p=1")

}
