package controllers

import models.User
import play.api.libs.json._
import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import utils.JsonFormatter._

class Application extends Controller {
  def index = TODO

  //    Action {
  //    Ok("Hello world")
  //  }

  def echo = Action { request =>
    Ok("Got request [" + request + "]")
  }

  def getJson = Action { request =>
    val user = User("damotou1")
    val json = Json.toJson(user)
    Ok(json)
  }

  def show(age: Int) = Action {
    Ok(s"Got age [$age] ")
  }

  def xmlResult = Action {
    Ok(<message>hello,world</message>)
  }

  def html = Action {
    Ok(<h1>this is a H1</h1>).as(HTML)
  }

  def session = Action { request =>
    Ok("Session saved").withSession(request.session + ("theme" -> "blue"))
  }

  def futureHello = Action.async {
    Future {
      "hello"
    }.map(Ok(_))
  }
}
