package com.cscie88a.week3

// write code for problem 3a below
object MyStudent{
  val firstName:String = "Praveen"
  val lastName: String = "Karnam"

  def greet(): String = {
    s"Hello ${firstName.toUpperCase} ${lastName.toUpperCase}"
  }
}