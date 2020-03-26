package com.cscie88a.week6

import org.scalatest.{ WordSpec, BeforeAndAfterAll, Matchers }

class FunctionUtils2Test
    extends WordSpec
    with Matchers
    with BeforeAndAfterAll {
    // add your tests below
    "tests" should {

      "all pass" ignore {
        true should be (false)
      }
    }

  "prefixLogger" should {
    "prefix" in {
      FunctionUtils2.prefixLogger("<scala>")("rocks") should be ("<scala> rocks")
    }
  }
  "sumInt" should {
    "sum" in {
      FunctionUtils2.sumInt(List(3, 4, 5)) should be (12)
    }
  }
  "productInt" should {
    "multiply" in {
      FunctionUtils2.productInt(List(2, 3, 4)) should be (24)
    }
  }
  "all" should {
    "return true if all items in list are true" in {
      FunctionUtils2.all(List(true, true, true)) should be (true)
    }
    "return false if at-least one item in list is false" in {
      FunctionUtils2.all(List(false, true, true)) should be (false)
    }
  }
  "any" should {
    "return true if atleast one item in list is true" in {
      FunctionUtils2.any(List(true, false, false)) should be (true)
    }
    "return false if all items in list is false" in {
      FunctionUtils2.any(List(false, false, false)) should be (false)
    }
  }
  "tokenize" should {
    "return the tokens of words" in {
      FunctionUtils2.tokenize((List("This is Praveen", "Prasanna is awesome", "Pranav is cute"))) should be
      (List("This", "is", "Praveen", "Prasanna", "is", "awesome", "Pranav", "is", "cute"))
    }
  }
  "updateCounts" should {
    "return counts of words in list updating the current word count" in {
      FunctionUtils2.updateCounts("this", Map("this" -> 5, "is" -> 1)) should be (Map("this" -> 6, "is" -> 1))
    }
    "add the word with count 1 if the word does not exists" in {
      FunctionUtils2.updateCounts("a", Map("this" -> 5, "is" -> 1)) should be (Map("this" -> 5, "is" -> 1, "a" -> 1))
    }
  }
}
