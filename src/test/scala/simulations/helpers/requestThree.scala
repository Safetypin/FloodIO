import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestThree {
  def request = http("request_3")
    .get("/computers/6")


}
