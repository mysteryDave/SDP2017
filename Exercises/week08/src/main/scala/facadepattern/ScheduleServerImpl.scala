package facadepattern

case class ScheduleServerImpl() extends ScheduleServer {
  override def startBooting: Unit = println("Starting server boot")

  override def readSystemConfigFile: Unit = println("Prepare system configuration")

  override def init: Unit = println("Begin initialisation")

  override def initializeContext: Unit = println("Initialise context")

  override def initializeListeners: Unit = println("Initialise listeners")

  override def createSystemObjects: Unit = println("Create system objects")

  override def releaseProcesses: Unit = println("Release processes")

  override def destory: Unit = println("Begin destruction")

  override def destroySystemObjects: Unit = println("Destroy system objects")

  override def destoryListeners: Unit = println("Destroy listeners")

  override def destoryContext: Unit = println("Destroy context")

  override def shutdown: Unit = println("Shutdown server")
}
