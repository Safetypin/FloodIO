import io.gatling.core.Predef._
import io.gatling.http.Predef._

object requestTen {
  def request = http("request_10") // Here's an example of a POST request
    .post("/computers")
    .formParam("""name""", """Beautiful Computer""") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
    .formParam("""introduced""", """2012-05-30""")
    .formParam("""discontinued""", """""")
    .formParam("""company""", """37""")

}
