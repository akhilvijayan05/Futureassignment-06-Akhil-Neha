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

  def getListOfFiles(dir: String):List[File] = {

    try {
      val file = new File(dir)
      //if (file.exists && file.isDirectory) {
      for (list <- file.listFiles.toList) {
        if (list.isFile) {
          listoffile += list
        }
        else
          getListOfFiles(list.toString)
      }
      // } else {

      // List[File]()
      //}
      listoffile.toList
    }catch {
      case ex:FileNotFoundException =>{println(ex.getMessage);List[File]()}
      case ex:NotDirectoryException =>{println(ex.getMessage);List[File]()}
      case ex:Exception => {println(ex.getMessage);List[File]()}
    }

  }
}

