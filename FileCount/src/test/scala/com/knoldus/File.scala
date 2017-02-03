package com.knoldus

/**
  * Created by akhil on 2/2/17.
  */
import java.io.FileNotFoundException
import java.nio.file.NotDirectoryException

import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

class File extends FunSuite {

val obj=new FileCounter
  val filename = "/home/akhil/IdeaProjects/FileCount/src/main/resources/Directory1"
  val res=obj.find(filename)

  test("List of Files"){
    assert(Await.result(res,2.second).length==5)
  }
  test("FileNotFoundException"){
    intercept[FileNotFoundException]{
      obj.find("/home/home/")
    }
  }
  test("Not a directory"){
    intercept[NotDirectoryException]{
      obj.find("/home/akhil/IdeaProjects/FileCount/src/main/resources/Directory1/File1.txt")
    }

  }
}