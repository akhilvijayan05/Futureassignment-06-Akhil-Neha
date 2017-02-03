package com.knoldus

import java.io.{File, FileNotFoundException}
import java.nio.file.NotDirectoryException

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by akhil on 2/2/17.
  */
class FileCounter {

  val listoffile = new ListBuffer[File]
  def find(filename:String):Future[List[File]]={

    Future{getListOfFiles(filename)}

  }

  @throws[FileNotFoundException]
  def getListOfFiles(dir: String):List[File] = {


      val file = new File(dir)
      if (file.exists && file.isDirectory) {

      for (list <- file.listFiles.toList) {

        if (list.isFile) {

          listoffile += list
        }
        else

          getListOfFiles(list.toString)
      }
      } else {
      if(!file.exists())
        throw new FileNotFoundException

       List[File]()
      }
      listoffile.toList

  }
}

