package com.knoldus

/**
  * Created by akhil on 2/2/17.
  */
import java.io.FileNotFoundException
import java.nio.file.NotDirectoryException

import java.io.FileNotFoundException

import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

class File extends FunSuite {

val obj=new FileCounter
  val filename = "/home/akhil/IdeaProjects/FileCount/src/main/resources/Directory1"


 test("FileNotFoundException"){

    intercept[FileNotFoundException] {

      obj.getListOfFiles("/home/home")
    }
  }
  test("List of Files"){

    assert(Await.result(obj.find(filename),2.second).length==5)
  }
}