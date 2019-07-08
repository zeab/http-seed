
//Imports
import Settings._
import Dependencies._
import ModuleNames._

//Sbt Log Level
logLevel := Level.Info

//Add all the command alias's
CommandAlias.allCommandAlias

lazy val httpseed = (project in file("."))
  .settings(rootSettings: _*)
  .enablePlugins(SonaType)
