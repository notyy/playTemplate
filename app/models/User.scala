package models

import java.util.Date

case class User[T](name: String, birthDay: Date,isActive: Char,special:T)