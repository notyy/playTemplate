package utils

import models.User
import play.api.libs.json.{Format, Json}

object JsonFormatter {
  implicit val userFormats: Format[User] = Json.format[User]

}
