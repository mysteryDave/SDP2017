package vendor

import scala.io.Source

/**
  * Created by samia on 20/04/2017.
  */
class ProgramParserImp extends ProgramParser {


  override def parse(file: String): InstructionList = {
    val lines = Source.fromFile(file).getLines()
    var instructionL: InstructionList = Vector[Instruction]()
    for (line <- lines) {
      instructionL = instructionL ++: parseString(line)
    }
    instructionL
  }

  override def parseString(string: String): InstructionList = {
    var instructionLines: Array[String] = string.split("\n")
    var result: InstructionList = Vector[Instruction]()


    for (str <- instructionLines) {
      var vInt: Vector[Int] = Vector[Int]()
      var wordInst: String = str
      if (str.contains(" ")) {
        val splitted = str.split(" ")
        wordInst = splitted(0)
        vInt = vInt :+ splitted(1).toInt
      }
      result = result :+ new Instruction(wordInst, vInt)
    }
    result
  }
}
