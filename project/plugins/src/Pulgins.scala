import sbt._
 
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val akkaPlugin = "se.scalablesolutions.akka" % "akka-sbt-plugin" % "0.10" 
  val sbtIdeaRepo = "sbt-idea-repo" at "http://mpeltonen.github.com/maven/" 
  val sbtIdea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.1-SNAPSHOT"
}

