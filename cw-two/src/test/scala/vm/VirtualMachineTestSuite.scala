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

    it("[D01] should catch a buffer underflow") {
        val overPullCode = vmParser.parse("programs/p10.vm")
      intercept[MachineUnderflowException] {
        vm.execute(overPullCode)
      }
    }

    //Is it better to silently ignore this (error may matter to user.) or better to raise exception?
    it("[D02] additional (redundant?) iconst arguments are ignored") {
        val dropOverArgs = vendorParser.parse("programs/p11.vm")
        assert(dropOverArgs(0).args == Vector(4))
    }

    it("[D03] should catch missing iconst arguments") {
      intercept[InvalidBytecodeException] {
        vmParser.parse("programs/p12.vm")
      }
    }

    it("[D04] should raise an exception for badly formatted file") {
      intercept[InvalidBytecodeException] {
        vmParser.parse("programs/p13.vm")
      }
    }

    describe("Check other functions perform correctly") {

      val vmFuncP = VirtualMachineFactory.virtualMachineParser
      val vmFunc = VirtualMachineFactory.virtualMachine

      it("[D10] imul should work correctly") { //multiply
        val testCode = vmFuncP.parseString("iconst 7\niconst 6\nimul")
        var next = vmFunc.executeOne(testCode)
        assert(next._2.state.head == 7)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 6)
        next = next._2.executeOne(next._1)
        assert(next._2.state(0) == 42)
      }

      it("[D11] idiv should work correctly") { //divide
        val testCode = vmFuncP.parseString("iconst 2\niconst 10\nidiv")
        var next = vmFunc.executeOne(testCode)
        assert(next._2.state.head == 2)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 10)
        next = next._2.executeOne(next._1)
        assert(next._2.state(0) == 5)
      }

      it("[D12] irem should work correctly") {  //remainder(modulus)
        val testCode = vmFuncP.parseString("iconst 3\niconst 10\nirem")
        var next = vmFunc.executeOne(testCode)
        assert(next._2.state.head == 3)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 10)
        next = next._2.executeOne(next._1)
        assert(next._2.state(0) == 1)
      }

      it("[D13] ineg should work correctly") {  //negate
      val testCode = vmFuncP.parseString("iconst 96\nineg")
        var next = vmFunc.executeOne(testCode)
        assert(next._2.state.head == 96)
        next = next._2.executeOne(next._1)
        assert(next._2.state(0) == -96)
      }

      it("[D14] iinc and idec should work correctly") {  //negate
      val testCode = vmFuncP.parseString("iconst 1\niinc\nidec\nidec\nidec\niinc")
        var next = vmFunc.executeOne(testCode)
        assert(next._2.state.head == 1)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 2)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 1)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 0)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == -1)
        next = next._2.executeOne(next._1)
        assert(next._2.state(0) == 0)
      }

      it("[D15] idup should work correctly") {  //negate
      val testCode = vmFuncP.parseString("iconst 1\niconst 3\nidup\nidup")
        var next = vmFunc.executeOne(testCode)
        assert(next._2.state.head == 1)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 3)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 3)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 3)
      }
    }

    describe("boundary testing") {

      val vmBoundP = VirtualMachineFactory.virtualMachineParser
      val vmBound = VirtualMachineFactory.virtualMachine

      it("[D20] a constant can be incremented over 127") {
        val testCode = vmBoundP.parseString("iconst 127\niinc\niinc\niinc\niinc\niinc")
        var next = vmBound.executeOne(testCode)
        assert(next._2.state.head == 127)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 128)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 129)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 130)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 131)
        next = next._2.executeOne(next._1)
        assert(next._2.state(0) == 132)
      }

      it("[D21] maxByte can be multiplied up to /Int.maxValue") {
        val testCode = vmBoundP.parseString("iconst 127\niconst 127\niconst 127\nidup\nimul\nimul\nimul")
        var next = vmBound.executeOne(testCode)
        assert(next._2.state.head == 127)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 127)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 127)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 127)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 16129)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 2048383)
        next = next._2.executeOne(next._1)
        assert(next._2.state.head == 260144641)
      }
    }
  }
}
