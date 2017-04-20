package bc

import vm.VirtualMachine

/**
  * Created by Samia on 20/04/2017.
  */
class iswap extends ByteCode {
  override val code: Byte = bytecode("iswap")

  override def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()._1
    val y = vm.pop()._1
    vm.push(x)
    vm.push(y)

  }
}
