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
  // TODO
  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactoryImp

  // TODO
  def vendorParser: ProgramParser = new ProgramParserImp

  // TODO
  def byteCodeParser: ByteCodeParser = new ByteCodeParserImp

  // TODO
  def virtualMachineParser: VirtualMachineParser = new VirtualMachineParserImp

  // TODO
  def virtualMachine: VirtualMachine = new VirtualMachineImp
}
