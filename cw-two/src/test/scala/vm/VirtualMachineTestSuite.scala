package vm

import java.nio.BufferUnderflowException

import factory.VirtualMachineFactory
import org.scalatest.FunSpec

/**
  * Created by David Tucker on 21/04/2017.
  */
class VirtualMachineTestSuite extends FunSpec {
  describe("Additional VM files for testing.") {
    val vmParser = VirtualMachineFactory.virtualMachineParser
    val vm = VirtualMachineFactory.virtualMachine
    it("should catch an buffer underrun") {
        val overPullCode = vmParser.parse("programs/p10.vm")
      intercept[MachineUnderflowException] {
        vm.execute(overPullCode)
      }
    }
  }
}
