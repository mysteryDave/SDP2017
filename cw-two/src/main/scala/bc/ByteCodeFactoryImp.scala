package bc

/**
  * Created by dtucke03 on 20/04/2017.
  */
class ByteCodeFactoryImp extends ByteCodeValues with ByteCodeFactory {
  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    val theInstr = for(name: String <- names if bytecode(name) == byte) yield name
    theInstr(0) match {
      case "iconst" => new iConstByte(args(0))
      case "iadd" => new iadd
      case "isub" => new iSubByte
      case "imul" => new imul
      case "idiv" => new iDivByte
      case "irem" => new iRemByte
      case "ineg" => new iNegByte
      case "iinc" => new iIncByte
      case "idec" => new iDecByte
      case "iswap" => new iswap
      case "idup" => new iDupByte
      case "print" => new printByte
      case _ => throw new InvalidBytecodeException("Unknown Byte Code Operation '" + theInstr + "' BYTE:" + byte + "| args:" + args)
    }
  }

}

