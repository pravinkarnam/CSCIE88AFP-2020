package com.cscie88a.week3

import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

class HarvardStudentTest
    extends WordSpec
    with Matchers
    with BeforeAndAfterAll {


  "HarvardStudent case class" should {
    // add unit tests for problem 4 below
    "test full name and failed subject" in {
      val hstudent: HarvardStudent = HarvardStudent("Praveen,Karnam,FP,90")
      hstudent.fullName should be("PRAVEEN KARNAM")
      hstudent.failedSubject should be(false)
    }
    "take named parameters and return the failedSubject method correctly" in {
      val hstudent: HarvardStudent = HarvardStudent(subjectName="Molecular Biology", percentScore=41,
        firstName="Chokkalingam", lastName="Gnanasabapathy")
      hstudent.failedSubject should be(true)
      val hstudent1: HarvardStudent = HarvardStudent(subjectName="Psychology", percentScore=51,
        firstName="Muniandi", lastName="Pichandi")
      hstudent1.failedSubject should be(false)
    }
    "test fullName method" in {
      val hstudent: HarvardStudent = HarvardStudent("Praveen","K","FP",80)
      hstudent.fullName should be("PRAVEEN K")

      val hstudent1: HarvardStudent = HarvardStudent("Praveen","","FP",80)
      hstudent1.fullName should be("PRAVEEN")

      val hstudent2: HarvardStudent = HarvardStudent("","Karnam","FP",80)
      hstudent2.fullName should be("KARNAM")
    }

    "test failedSubject method" in {
      val hstudent: HarvardStudent = HarvardStudent("Praveen","K","FP",-90)
      hstudent.failedSubject should be(true)

      val hstudent1: HarvardStudent = HarvardStudent("Praveen","","FP",0)
      hstudent.failedSubject should be(true)

      val hstudent2: HarvardStudent = HarvardStudent("Praveen","","FP",50)
      hstudent2.failedSubject should be(false)

      val hstudent3: HarvardStudent = HarvardStudent("Praveen","","FP",49)
      hstudent3.failedSubject should be(true)

    }
    "instantiate the class using apply method a.k.a smart constructor" in {
      val hstudent: HarvardStudent = HarvardStudent("Praveen,Karnam,FP,90")
      hstudent.firstName should be("Praveen")
      hstudent.lastName should be("Karnam")
      hstudent.subjectName should be("FP")
      hstudent.percentScore should be(90.0)
    }
  }

  "HarvardStudent list operations" should {
    // add unit tests for problem 5 below
    "instantiate list of students string to list of HarvardStudent objects" in {
      val csvList: List[String] = List("James,Dean,Math,75", "Brad,Pitt,Math,35")
      val listOfStudents: List[HarvardStudent] = HarvardStudent.fromCSVStrings(csvList)
      val jamesStudent = HarvardStudent.apply("James,Dean,Math,75")
      val bradStudent = HarvardStudent.apply("Brad,Pitt,Math,35")
      listOfStudents(0).hashCode() should be(jamesStudent.hashCode())
      listOfStudents(1).hashCode() should be(bradStudent.hashCode())
      listOfStudents(0) should be(jamesStudent)
      listOfStudents(1) should be(bradStudent)
    }

  }

  "HarvardStudent average score" should {
    "be correct" in {
      val csvList: List[String] = List("James,Dean,Math,75", "Brad,Pitt,Math,35")
      val listOfStudents: List[HarvardStudent] = HarvardStudent.fromCSVStrings(csvList)
      HarvardStudent.avgStudentScore(listOfStudents) should be(55)
    }
    "return zero for an empty list " in {
      val csvList: List[String] = List()
      val listOfStudents: List[HarvardStudent] = HarvardStudent.fromCSVStrings(csvList)
      HarvardStudent.avgStudentScore(listOfStudents) should be(0)
    }
  }

  "HarvardStudent average passing score" should {
    "exclude failed candidates and return correct average of only passing student's scores" in {
      val studentActors= List(
        HarvardStudent("James", "Dean", "Math", 75),
        HarvardStudent("Brad", "Pitt", "Math", 35),
        HarvardStudent("Will", "Smith", "Math", 95)
      )
      HarvardStudent.avgPassingScore(studentActors) should be(85)
    }
  }

}
