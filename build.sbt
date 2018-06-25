lazy val commonSettings = Seq(
  organization := "com.github.adowrath",
  scalaVersion := "2.12.6",
  description := "ChaiJ is a Java assertion library in the expect-style.",

  licenses := Seq(
    "MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")
  ),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/adowrath/chaij"),
          "scm:git:https://github.com/adowrath/chaij.git",
          "scm:git:git@github.com:adowrath/chaij.git"
    )
  ),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  credentials += Credentials(Path.userHome / ".sbt" / ".credentials"),
  publishMavenStyle := true,
  Test / publishArtifact := false,

  compile / javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),

  libraryDependencies ++= Seq(
    mockitoLib,
    junitLib,
    "org.junit.platform" % "junit-platform-runner" % "1.2.0" % "test",
    "org.junit.jupiter" % "junit-jupiter-engine" % "5.1.0" % "test",
    "org.junit.vintage" % "junit-vintage-engine" % "5.1.0" % "test",
  ),
)

lazy val nonScalaSettings = Seq(
  crossPaths := false,
  autoScalaLibrary := false,
)

lazy val mockitoVer = "2.8.47"
lazy val junitVer   = "4.12"

lazy val mockitoLib = "org.mockito" % "mockito-core" % mockitoVer
lazy val   junitLib = "junit" % "junit" % junitVer % "test"

lazy val root = (project in file("."))
    .settings(commonSettings: _*)
    .aggregate(core, junit)

lazy val core = (project in file("core"))
  .settings(name := "chaiJ-core")
  .settings(commonSettings: _*)
  .settings(nonScalaSettings: _*)

lazy val junit = (project in file("junit"))
  .settings(name := "chaiJ-junit")
  .settings(commonSettings: _*)
  .settings(nonScalaSettings: _*)
  .settings(libraryDependencies += "junit" % "junit" % junitVer % "compile")
  .dependsOn(core)

useGpg := true

skip in publish := true
parallelExecution in ThisBuild := false
