package com.cscie88a.week7

import cats.implicits._
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}
import fs2.{io, text, Stream}

class MySimpleStreamsTest
  extends WordSpec
  with Matchers
  with BeforeAndAfterAll {
  "Problem 1" should {
    "contain val numTo10 which contains a stream of Int from 1 to 10" in {
      val result = (1 to 10).toList
      MySimpleStreams.numTo10.toList should be(result)
    }
    "contain val numFrom10To20 which contains a stream of Int from 10 to 20" in {
      val result = (10 to 20).toList
      MySimpleStreams.numFrom10To20.toList should be(result)
    }
    "contain val numTo20 which contains a stream of Int from 1 to 20" in {
      val result = (1 to 20).toList
      MySimpleStreams.numTo20.toList should be(result)
    }
  }
  "Problem 2" should {
    "return even numbers from val evens" in {
      val result = List(0,2,4,6,8)
      MySimpleStreams.evens.take(5).toList should be(result)
    }
    "return odd numbers from val odds" in {
      val result = List(1,3,5,7,9)
      MySimpleStreams.odds.take(5).toList should be(result)
    }
    "return natural numbers from val natutalNumbers" in {
      val result = List(0,1,2,3,4)
      MySimpleStreams.naturalNumbers.take(5).toList should be(result)
    }
  }
  "Problem 3" should {
    "multN should return multiples of wholenumbers" in {
      val result = (1 to 10).toList.map(_ * 2)
      MySimpleStreams.multN(2).take(10).toList should be(result)
    }
    "mult3 should return multiples of 3" in {
      val result = (1 to 3).toList.map(_ * 3)
      MySimpleStreams.mult3.take(3).toList should be(result)
    }
    "mult4 should return multiples of 4" in {
      val result = (1 to 3).toList.map(_ * 4)
      MySimpleStreams.mult4.take(3).toList should be(result)
    }
    "mult34Pairs contains a stream of strings of the pairwise multiples of 3 and 4" in {
      val result: List[String] = List("[3,4]","[6,8]", "[9,12]", "[12,16]")
      MySimpleStreams.mult34Pairs.take(4).toList should be(result)
    }
    "mult12 contains a stream values mult12 that contains a stream of multiples of 12" in {
      val result = List(12, 24, 36, 48)
      MySimpleStreams.mult12.take(4).toList should be (result)
    }
  }

  "Problem 4" should {
    "pythTest returns true when a^2 + b^2 = c^2 and false otherwise" in {
      val pythValid = Tuple3(3, 4, 5)
      val pythInvalid = Tuple3(3, 4, 6)

      MySimpleStreams.pythTest(pythValid) should be(true)
      MySimpleStreams.pythTest(pythInvalid) should be(false)
    }
  }
}


