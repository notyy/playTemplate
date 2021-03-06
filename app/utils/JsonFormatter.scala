package utils

import java.util.Date

import models.User
import play.api.libs.json._
import play.api.libs.json.Writes.dateWrites

object JsonFormatter {
  implicit val customDateWrites: Writes[Date] = dateWrites("yyyy-MM-dd HH:mm:ss")

  implicit object CharFormats extends Format[Char] {
    override def writes(c: Char): JsValue = Json.toJson(c.toString)

    override def reads(json: JsValue): JsResult[Char] = json match {
      case JsString(x) if x.length == 1 => JsSuccess(x.head)
      case e@_ => JsError(s"can not parse $e")
    }
  }

  implicit def userFormats[T: Format]: Format[User[T]] = Json.format[User[T]]

}
