/**
  * Created by David Tucker on 18/04/2017.
  */

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

case class Counter(var count: Int = 0) {
  def inc(nStep: Int = 1): Counter = copy(count + nStep)
  def dec(nStep: Int = 1): Counter = copy(count - nStep)
  def adjust(nFunction: Adder): Counter = copy(nFunction.add(count))
}
