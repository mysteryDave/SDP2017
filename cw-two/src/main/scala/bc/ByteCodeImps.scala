package bc

import vm.VirtualMachine

/**
  * Created by dtucke03 on 20/04/2017.
  */


class iConstByte(number: Int) extends ByteCode {
  val byteString = "iconst"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString + " " + "number"

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(number)
}

class iSubByte() extends ByteCode {
  val byteString = "isub"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop()._1 - vm.pop()._1)
}

class iDivByte() extends ByteCode {
  val byteString = "idiv"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val value1 = vm.pop()._1
    val value2 = vm.pop()._1
    if (value2 <= 0) {
      throw new ArithmeticException(s"Integer division by zero: $value1 / $value2")
    }
    vm.push(value1 / value2)
  }
}

class iRemByte() extends ByteCode {
  val byteString = "irem"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val value1 = vm.pop()._1
    val value2 = vm.pop()._1
    if (value2 <= 0) {
      throw new ArithmeticException(s"Integer division by zero: $value1 / $value2")
    }
    vm.push(value1 % value2)
  }
}

class iNegByte() extends ByteCode {
  val byteString = "ineg"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(-vm.pop()._1)
}

class iIncByte() extends ByteCode {
  val byteString = "iinc"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop()._1 + 1)
}

class iDecByte() extends ByteCode {
  val byteString = "idec"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop()._1 - 1)
}

class iDupByte() extends ByteCode {
  val byteString = "idup"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val nPulledValue = vm.pop()._1
    vm.push(nPulledValue)
    vm.push(nPulledValue)
  }
}

class printByte() extends ByteCode {
  val byteString = "print"
  override val code: Byte = bytecode(byteString)

  override def toString = byteString

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    println(vm.pop()._1)
    vm
  }
}