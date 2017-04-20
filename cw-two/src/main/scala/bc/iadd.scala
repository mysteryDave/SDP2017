package bc

import vm.VirtualMachine

/**
  * Created by Samia on 20/04/2017.
  */
class iadd extends ByteCode {
  override val code: Byte = bytecode("iadd")

  override def execute(vm: VirtualMachine): VirtualMachine = {
    vm.push(vm.pop()._1 + vm.pop()._1)

  }
}
