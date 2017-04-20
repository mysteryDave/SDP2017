package vm
import bc.ByteCode
import factory.VirtualMachineFactory
import vendor.Instruction

/**
  * Created by dtucke03 on 20/04/2017.
  */
class VirtualMachineParserImp extends VirtualMachineParser {
  val byteParse = VirtualMachineFactory.byteCodeParser
  type InstructionList = Vector[Instruction]

  def parseInstructionList(instructionsL: InstructionList): Vector[ByteCode] = {
    var bytes = Vector[Byte]()
    for (instruction <- instructionsL) {
      bytes = bytes :+ byteParse.bytecode(instruction.name)
      for (i <- instruction.args) bytes = bytes :+ i.toByte
    }
    println("BYTES LIST " + bytes)
    byteParse.parse(bytes)
  }
  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] =
    parseInstructionList(VirtualMachineFactory.vendorParser.parse(file))

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] =
    parseInstructionList(VirtualMachineFactory.vendorParser.parseString(str))
}
