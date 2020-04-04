package com.cscie88a.week7

import cats.implicits._
import fs2.{INothing, Pure, Stream, io, text}

object MySimpleStreams {

  // Problem 1
  val numTo10 = Stream.emits(1 to 10)

  val numFrom10To20 = Stream.emits(10 to 20)

  val numTo20 = numTo10 ++ numFrom10To20.drop(1)


  // Problem 2
  val evens = Stream.iterate(0)(_ + 1).filter( _ % 2 == 0)

  val odds = Stream.iterate(0)(_ + 1).filter( _ % 2 == 1)

  val naturalNumbers = evens.interleave(odds)

  // Problem 3
  def multN(n: Int): Stream[Pure, Int] = {
    val wholeNumbers = Stream.iterate(1)(_ + 1)
    wholeNumbers.map(_ * n)
  }
//
  val mult3 = multN(3)

  val mult4 = multN(4)

  val mult34Pairs = {
    mult3.zipWith(mult4) { (a,b) => s"[${a},${b}]" }
  }

  val mult12 = {
    val zipped = for {
      a <- mult3
      b <- mult4
    } yield a*b
    zipped.filter(_ % 12 == 0)
  }

  // Problem 4
  def pythTest(t: Tuple3[Int, Int, Int]): Boolean = {
    scala.math.pow(t._1,2) + scala.math.pow(t._2,2) == scala.math.pow(t._3,2)
  }

  val upto100: Stream[Pure, Int] = Stream.emits(1 to 100)
//
  val pythTriples: Stream[Pure, (Int, Int, Int)] = {
    val triplets = for {
      a <- upto100
      b <- upto100
      c <- upto100
    } yield (a,b,c)
    triplets.filter(pythTest)
  }
}
