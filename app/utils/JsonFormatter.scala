package utils

import models.User
import play.api.libs.json.{Json, Writes}

object JsonFormatter {
  implicit val userWrites: Writes[User] = Json.writes[User]

}
