package com.cscie88a.week3

import org.scalatest.{ WordSpec, BeforeAndAfterAll, Matchers }

final class MyStudentTest
  extends WordSpec
  with Matchers
  with BeforeAndAfterAll {

  // add unit tests for problem 3 here
  "MyStudent object " should {
    "have a greet method which returns Hello PRAVEEN KARNAM" in {
      MyStudent.greet should be("Hello PRAVEEN KARNAM")
    }
  }
}
