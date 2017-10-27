import flood._
import io.gatling.core.Predef._
import scala.concurrent.duration._


class BasicSimulation extends Simulation {

  val httpConf = httpConfigFlood
    .baseURL("http://computer-database.gatling.io") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(
    forever() {
      exec(requestOne.request)
        .pause(7) // Note that Gatling has recorder real time pauses
        .exec(requestTwo.request)
        .pause(2)
        .exec(requestThree.request)
        .pause(3)
        .exec(requestFour.request)
        .pause(2)
        .exec(requestFive.request)
        .pause(670 milliseconds)
        .exec(requestSix.request)
        .pause(629 milliseconds)
        .exec(requestSeven.request)
        .pause(734 milliseconds)
        .exec(requestEight.request)
        .pause(5)
        .exec(requestNine.request)
        .pause(1)
        .exec(requestTen.request)
    })

  setUp(scn.inject(atOnceUsers(40)).protocols(httpConf)
    .throttle(
      reachRps(10) in (60),
      holdFor(60),
      jumpToRps(20),
      holdFor(60),
      jumpToRps(30),
      holdFor(60),
      jumpToRps(40),
      holdFor(60)
    ))
}
