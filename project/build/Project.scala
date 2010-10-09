import sbt._

class Project(info: ProjectInfo) extends DefaultWebProject(info) with AkkaProject with IdeaProject {
  val akkaKernel = "se.scalablesolutions.akka" % "akka-kernel_2.8.0" % "0.10" % "compile"
  val jsr311 = "javax.ws.rs" % "jsr311-api" % "1.1" % "compile" withSources()
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.14" % "test"  // jetty is only need for testing
}
