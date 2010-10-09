/**
 * Copyright (C) 2009-2010 Scalable Solutions AB <http://scalablesolutions.se>
 */

package sample.rest.scala

import javax.ws.rs.{GET, Path, Produces}
import se.scalablesolutions.akka.actor.{SupervisorFactory, Actor}
import se.scalablesolutions.akka.config.ScalaConfig._

class Boot {
  	val factory = SupervisorFactory(
		SupervisorConfig(
			RestartStrategy(OneForOne, 3, 100, List(classOf[Exception])),
			Supervise(Actor.actorOf[MyActor], LifeCycle(Permanent)) :: Nil))
	factory.newInstance.start
}

private case object Hello

@Path("/hello")
class HelloService {
  @GET
  @Produces(Array("text/html"))
  def hello = {
    val myActor = Actor.actorOf[MyActor]
    //I don't understand why SupervisorFactory do not start the actor ?????
    myActor.start
    (myActor !! Hello).getOrElse("Hyyy")

  }


}

class MyActor extends Actor {
  import self._

  def receive = {
    case Hello => reply(<h1>Hello, World</h1>.toString)
  }
}