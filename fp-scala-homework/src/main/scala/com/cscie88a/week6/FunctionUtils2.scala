package com.cscie88a.week6

object FunctionUtils2 {
  val prefixLogger: String => (String => String) = prefix => str => prefix + " " + str

  def sumInt(inList: List[Int]): Int = {
    inList.foldRight(0)(_ + _)
  }

  def productInt(inList: List[Int]): Int = {
    inList.foldRight(1)(_ * _)
  }


  def all(inList: List[Boolean]): Boolean = {
    inList.foldRight(true)(_ && _)
  }


  def any(inList: List[Boolean]): Boolean = {
    inList.foldRight(false)(_ || _)
  }


  def tokenize(text: List[String]): List[String] = {
    for {
      line  <- text
      word  <- line.split(" ")
    }
      yield word
  }

  def updateCounts(word: String, counts: Map[String, Int]): Map[String, Int] = {
    val valueOfWord = counts getOrElse(word, 1)
    if (counts contains word){
      counts + (word -> (valueOfWord + 1))
    }
    else {
      counts + (word->valueOfWord)
    }
  }

//  def wordCount(text: List[String]): Map[String, Int] = {
//    val words:List[String] = tokenize(text)
//
//
//  }

}
