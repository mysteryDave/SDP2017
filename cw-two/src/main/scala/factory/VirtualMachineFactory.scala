package factory

import bc.{ByteCodeFactory, ByteCodeFactoryImp, ByteCodeParser, ByteCodeParserImp}
import vendor.{ProgramParser, ProgramParserImp}
import vm.{VirtualMachine, VirtualMachineImp, VirtualMachineParser, VirtualMachineParserImp}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactoryImp


  def vendorParser: ProgramParser = new ProgramParserImp


  def byteCodeParser: ByteCodeParser = new ByteCodeParserImp


  def virtualMachineParser: VirtualMachineParser = new VirtualMachineParserImp


  def virtualMachine: VirtualMachine = new VirtualMachineImp
}
