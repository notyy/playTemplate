package controllers

import java.util.Date
import javax.inject.{Inject, Singleton}

import models.User
import play.api.libs.json._
import play.api.mvc.{AbstractController, Action, Controller, ControllerComponents}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import utils.JsonFormatter._


@Singleton
class ApplicationController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index = TODO

  //    Action {
  //    Ok("Hello world")
  //  }

  def echo = Action { request =>
    Ok("Got request [" + request + "]")
  }

  def getJson = Action(parse.json) { request =>
    import utils.JsonFormatter._

    val user = User("damotou1",new Date(),'Y',"special")
    request.body.as[User[String]]
    Json.fromJson[User[String]](request.body)
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

  def customers = Action.async {
    Future {
      "hello"
    }.map(Ok(_))
  }
}
