package com.cscie88a.week6

object ListUtils {

  def add2: Int => Int = _ + 2

  def uptoN: Int => List[Int] = n => (0 to n).toList

  def allPairs_a: Seq[(Int, Int)] =
    (1 to 5).flatMap { a =>
      (10 to 50 by 10).map {b =>
        (a,b)
      }
    }

  def allPairs_b: Seq[(Int, Int)] =
    for {
      a <- (1 to 5)
      b <- (10 to 50 by 10)
    } yield (a,b)


  def rightTriangleTriples: Seq[(Int, Int, Int)] =
    for {
      a <- 1 to 10
      b <- 1 to 10
      c <- 1 to 10
      if (a * a + b * b == c * c)
    } yield (a,b,c)


    val gradePoints: Map[String, Int] = Map(
      "A" -> 90,
      "B" -> 80,
      "C" -> 70,
      "D" -> 60
    )

    def add10ToMapValues(inMap: Map[String, Int]): Map[String, Int] =
      inMap.transform((_, v) => v + 10)
}
