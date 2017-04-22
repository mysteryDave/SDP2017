package sml

/**
  * Created by DT on 22/04/2017.
  *
  * Jumps to first occurance of requested label in program
  * @throws NoSuchElementException in case of jump to label not existing in program
  */

case class BnzInstruction(label: String, opcode: String, register: Int, nextInstr: String) extends Instruction(label, opcode) {

  override def execute(m: Machine): Unit = {
    val value = m.regs(register)
    if (value != 0) {
      var counter = 0
      while (!nextInstr.equals(m.labels(counter)) && counter < m.prog.length) counter = counter + 1
      if (counter >= m.prog.length) throw new NoSuchElementException("Label: " + label + " tries to jump to instruction labelled: " + nextInstr + ". Cannot find " + nextInstr + ".")
      else m.pc = counter
    }
  }

  override def toString(): String = {
    super.toString + " check register " + register + ", jump to instruction: " + nextInstr + "\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, nextInstr: String) =
    new BnzInstruction(label, "bnz", register, nextInstr: String)
}
