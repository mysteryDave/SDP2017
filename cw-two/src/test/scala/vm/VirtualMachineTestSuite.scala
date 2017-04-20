package vm

import factory.VirtualMachineFactory
import org.scalatest.FunSpec

/**
  * Created by David Tucker on 21/04/2017.
  */
class VirtualMachineTestSuite extends FunSpec {
  describe("Additional VM files for testing.") {
    val vmParser = VirtualMachineFactory.virtualMachineParser
    it("should catch an buffer underrun") {
      intercept[MachineUnderflowException] {
        val code = vmParser.parse("programs/p10.vm")
      }
    }
  }
}
