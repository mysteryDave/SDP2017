package facadepattern

/*
** Facade used when detail can be hidden from the user.
** The user calls one method 'the facade' that in turn encapsulates the detail of steps required to complete the task.
*/

case class ScheduleServerFacade(scheduleServer: ScheduleServer) {
  def stopServer: Unit = {
    scheduleServer.releaseProcesses
    scheduleServer.destory
    scheduleServer.destroySystemObjects
    scheduleServer.destoryListeners
    scheduleServer.destoryContext
    scheduleServer.shutdown
  }

  def startServer = {
    scheduleServer.startBooting
    scheduleServer.readSystemConfigFile
    scheduleServer.init
    scheduleServer.initializeContext
    scheduleServer.initializeListeners
    scheduleServer.createSystemObjects
  }

}
