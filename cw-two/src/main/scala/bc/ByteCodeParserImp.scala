package bc

import factory.VirtualMachineFactory

/**
  * Created by samia on 20/04/2017.
  */
class ByteCodeParserImp extends ByteCodeParser {
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var result: Vector[ByteCode] = Vector[ByteCode]()
    var isIconst: Boolean = false
    for (i <- bc.indices) {
      if (isIconst) isIconst = false
      else if (bytecode("iconst") == bc(i)) {
        isIconst = true
        try {
          result = result :+ VirtualMachineFactory.byteCodeFactory.make(bc(i), bc(i + 1))
        } catch {
          case e: Exception => throw new InvalidBytecodeException("Byte code instruction 'iconst' missing parameter")
        }
      } else {
        result = result :+ VirtualMachineFactory.byteCodeFactory.make(bc(i))
      }

    }
    result

  }
}
