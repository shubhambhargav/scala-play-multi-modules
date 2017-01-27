name := "sample_multi_modules"

Common.settings

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
val additionalDependencies = Seq(
  ws,
  cache,
  evolutions
)

lazy val clubs = (project in file("modules/clubs"))
  .settings(Common.settings: _*)
  .settings(libraryDependencies ++= Common.dependencies)
  .settings(libraryDependencies ++= additionalDependencies)
  .settings(resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")
  .enablePlugins(PlayScala)

lazy val sports = (project in file("modules/sports"))
  .settings(Common.settings: _*)
  .settings(libraryDependencies ++= Common.dependencies)
  .settings(libraryDependencies ++= additionalDependencies)
  .settings(resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")
  .enablePlugins(PlayScala)

lazy val players = (project in file("modules/players"))
  .settings(Common.settings: _*)
  .settings(libraryDependencies ++= Common.dependencies)
  .settings(libraryDependencies ++= additionalDependencies)
  .settings(resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")
  .enablePlugins(PlayScala)
  .dependsOn(sports, clubs)

lazy val main = (project in file("."))
  .enablePlugins(PlayScala)
  .aggregate(clubs, sports)
  .dependsOn(clubs, sports)

libraryDependencies ++= Common.dependencies
libraryDependencies ++= additionalDependencies