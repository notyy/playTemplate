package utils

import java.util.Date

import models.User
import org.scalatest.{FunSpec, Matchers}
import play.api.libs.json.Json

class JsonFormatterTest extends FunSpec with Matchers {
  import JsonFormatter._

  describe("JsonFormatter"){
    it("can format User instance to Json format"){
      val user = User("notyy", new Date(),'Y',"special")
      val userJson = Json.toJson(user)
      println(s"$user to json is : $userJson")
    }
  }
}
