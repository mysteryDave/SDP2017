package sml

import scala.tools.nsc.util.ScalaClassLoader
import scala.reflect.runtime.{universe=>runTuni}

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
/*  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val DIV = "div"
  private final val SUB = "sub"
  private final val OUT = "out" */

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        val findInstr = "sml." + fields(1).toUpperCase.charAt(0) + fields(1).substring(1) + "Instruction"
        try {
          ScalaClassLoader(getClass.getClassLoader).tryToLoadClass(findInstr)

          /*
          val theInstr = Class.forName(findInstr).newInstance()
          def getTypeTag[T: runTuni.TypeTag](obj: T) = runTuni.typeTag[T]
          def instrType = getTypeTag(theInstr).tpe

          val instrCtor = runTuni.typeOf[instrType].declaration(runTuni.nme.CONSTRUCTOR).asMethod


          val instrClass: runTuni.ClassSymbol = runTuni.runtimeMirror(getClass.getClassLoader).classSymbol(Class.forName(findInstr))
          val instrMirror: runTuni.ClassMirror = runTuni.runtimeMirror(getClass.getClassLoader).reflectClass(instrClass)
          def getTypeTag[T: runTuni.TypeTag](obj: T) = runTuni.typeTag[T]
          val ctors = runTuni.typeOf[theInstr].declaration(runTuni.nme.CONSTRUCTOR).asMethod
          val ctorMirror = instrMirror.reflectConstructor(ctors)
          */
          program = program :+ instrCtor[Instruction]
        } catch {
          case e: ClassNotFoundException => println("Unknown instruction " + fields(1) + ", expecting class named '" + findInstr + "'")
        }
        /*
        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case x =>
            println(s"Unknown instruction $x")
        }
        */
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
