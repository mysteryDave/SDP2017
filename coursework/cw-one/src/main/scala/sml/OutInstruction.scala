package sml

class OutInstruction(label: String, op: String, val op1: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    println(value1)
  }

  override def toString(): String = {
    super.toString + " (print) " + op1
  }
}

object OutInstruction {
  def apply(label: String, op1: Int) =
    new OutInstruction(label, "out", op1)
}