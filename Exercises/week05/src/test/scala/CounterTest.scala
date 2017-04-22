import org.scalatest.FunSpec


/**
  * Created by David Tucker on 18/04/2017.
  */
class CounterTest extends org.scalatest.FunSpec {
  describe("The Counter") {
    it("Should default to zero") {
      assert(Counter().count == 0)
    }
    it("An example of the usage 10+1-1+1+1=12") {
      assert(Counter(10).inc().dec().inc().inc().count == 12)
    }
    it("Is possible to specify increment") {
      assert(Counter(10).inc(2).count == 12)
    }
    it("Is possible to specify decrement") {
      assert(Counter(10).dec(5).count == 5)
    }
    it("Is possible to pass adjust an Adder class") {
      val theAdder = new Adder(5)
      assert(Counter(4).adjust(theAdder).count == 9)
    }
  }
}
