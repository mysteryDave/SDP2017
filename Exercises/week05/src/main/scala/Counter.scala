/**
  * Created by David Tucker on 18/04/2017.
  */
case class Counter(var count: Int = 0) {
  def inc(nStep: Int = 1): Counter = copy(count + nStep)
  def dec(nStep: Int = 1): Counter = copy(count - nStep)
}
