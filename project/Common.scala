
//Imports
import java.time.Instant
//Sbt
import sbt.{Def, Opts, url}
import sbt.Keys._
import sbt.librarymanagement.{Developer, ScmInfo}

object Common {

  //Common Settings
  val useScalaVersion: String = "2.12.8"
  val useOrganization: String = "com.github.zeab"
  val useHomepage: String = "https://github.com/zeab/http-seed"
  val useGitHomepage:String = "https://github.com/zeab/http-seed.git"
  val useDevName: String = "Kevin Kosnik-Downs"
  val useDevEmail: String = "pyrosrppltoo@gmail.com"
  val useDevGithub: String = "https://github.com/zeab"

  //Get the current build time since epoch
  val buildTime: String = Instant.now.getEpochSecond.toString

  //Add this to a module to disable publishing
  val disablePublishing: Seq[Def.Setting[_]] = Seq(
    publishLocal := {},
    publish := {}
  )

  //Add the library's to this list that need to be excluded. Below is excluding certain log4j lib's
  val excludeSettings: Seq[Def.Setting[_]] = Seq(
    //libraryDependencies ~= { _.map(_.exclude("org.slf4j", "slf4j-log4j12")) }
  )

  //Sequence the base project settings so its easier to read
  def seqBaseProjectTemplate(versionNumber: String): Seq[Def.Setting[_]] = {
    Seq(
      version := versionNumber,
      scalaVersion := useScalaVersion,
      organization := useOrganization,
      homepage := Some(url(useHomepage)),
      scmInfo := Some(ScmInfo(url(useHomepage), useGitHomepage)),
      licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
      publishMavenStyle := true,
      publishTo := Some(
        if (isSnapshot.value) Opts.resolver.sonatypeSnapshots
        else Opts.resolver.sonatypeStaging
      ),
      developers := List(
        Developer(
          useOrganization,
          useDevName,
          useDevEmail,
          url(useDevGithub))),
      //publishConfiguration := publishConfiguration.value.withOverwrite(true),
      //publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true)
    )
  }

  def mapDockerLabels(name: String, version:String, buildTime:String): Map[String, String] = {
    Map(
      "org.label-schema.name" -> name,
      "org.label-schema.version" -> version,
      "org.label-schema.build-date" -> buildTime
    )
  }

  //Some assembly setting that have not been put into this application correctly
//  // No need to run tests while building jar
//  test in assembly := {}
//  // Simple and constant jar name
//  assemblyJarName in assembly := s"app-assembly.jar"
//  // Merge strategy for assembling conflicts
//  assemblyMergeStrategy in assembly := {
//    case PathList("reference.conf") => MergeStrategy.concat
//    case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
//    case _ => MergeStrategy.first
//  }

}
