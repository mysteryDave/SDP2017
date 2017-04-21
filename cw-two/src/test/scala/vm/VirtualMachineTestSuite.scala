package vm

import java.nio.BufferUnderflowException

import bc.InvalidBytecodeException
import factory.VirtualMachineFactory
import org.scalatest.FunSpec

/**
  * Created by David Tucker on 21/04/2017.
  */
class VirtualMachineTestSuite extends FunSpec {

  describe("Additional VM files for testing.") {

    val vmParser = VirtualMachineFactory.virtualMachineParser
    val vm = VirtualMachineFactory.virtualMachine
    val vendorParser = VirtualMachineFactory.vendorParser

    it("should catch a buffer underflow") {
        val overPullCode = vmParser.parse("programs/p10.vm")
      intercept[MachineUnderflowException] {
        vm.execute(overPullCode)
      }
    }

    it("additional (redundant?) iconst arguments are ignored") {
        val dropOverArgs = vendorParser.parse("programs/p11.vm")
        assert(dropOverArgs(0).args == Vector(4))
    }

    it("should catch missing iconst arguments") {
      intercept[InvalidBytecodeException] {
        vmParser.parse("programs/p12.vm")
      }
    }

    it("should raise an exception for badly formatted file") {
      intercept[InvalidBytecodeException] {
        vmParser.parse("programs/p13.vm")
      }
    }
  }
}
