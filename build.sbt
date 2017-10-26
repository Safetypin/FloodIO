import java.nio.file.{Files, Paths, StandardCopyOption}
import NativePackagerHelper._
import sbt.Keys.mappings

enablePlugins(JavaAppPackaging)
enablePlugins(GatlingPlugin)
name := "flood"

version := "0.1"

scalaVersion := "2.12.3"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.3.0" % "test"

topLevelDirectory := Some("user-files")

mappings in Universal  <<= (mappings in Universal) map { mappings =>
  mappings filter { case (_, name) => name.contains("config") || name.contains("shapeless")}
  }
  mappings in Universal ++= directory("/src/test/scala/simulations")
  mappings in Universal += { ((resourceDirectory in Test).value / "gatling.conf") -> "conf/reference.conf"}


val moveScenarios = taskKey[File]("move scenarios to target folder")

moveScenarios := {
  val source = baseDirectory.value + "/src/test/scala/simulations"
  val destination = target.value.toString + "/universal"

  println(source)
  println(destination)
  new File(source).listFiles.filter(f => f.isFile && f.ext.equals("scala"))
    .foreach(file => Files.copy(file.toPath, Paths.get(destination + "/" + file.name), StandardCopyOption.REPLACE_EXISTING))

  baseDirectory.value
}