package com.cscie88a.week3

// complete the code for problem 4 and 5 below
case class HarvardStudent(firstName:String, lastName:String, subjectName: String, percentScore: Double) {

  def fullName: String = s"${firstName.toUpperCase()} ${lastName.toUpperCase()}".strip()

  def failedSubject: Boolean = if (percentScore < 50) true else false

  override def toString: String = s"HarvardStudent with [firstName: $firstName, lastName: $lastName, " +
    s"subjectName:$subjectName, percentScore: $percentScore ]"

}

object HarvardStudent {
  def apply(csv: String): HarvardStudent = {
    val constructorParams = csv.split(",")
    HarvardStudent(constructorParams(0), constructorParams(1), constructorParams(2), constructorParams(3).toDouble)
  }

  def fromCSVStrings(csvList: List[String]):List[HarvardStudent] = {
    csvList.map({csv:String =>
      val arrayHStudent: Array[String] =  csv.split(",")
      HarvardStudent(arrayHStudent(0), arrayHStudent(1), arrayHStudent(2), arrayHStudent(3).toDouble)
    })
  }

  def avgStudentScore(listOfStudents : List[HarvardStudent]) : Double = {
    val numOfStudents: Int = listOfStudents.length
    if (numOfStudents > 0) {
    val sumScore: Double= listOfStudents.map({s:HarvardStudent => s.percentScore}).reduce(_ + _)
    sumScore/numOfStudents
    }
    else 0
  }

  def avgPassingScore(listOfStudents:List[HarvardStudent]): Double = {
    val passingScores: List[Double] = listOfStudents.map({s:HarvardStudent => s.percentScore}).filter(_ >= 50 )
    val passingStudents : Int = passingScores.length
    val sumScore: Double = passingScores.reduce(_ + _)
    sumScore/passingStudents
  }
}