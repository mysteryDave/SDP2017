import org.scalatest.FunSpec

/**
  * Created by David Tucker on 19/04/2017.
  */
class PersonTest extends FunSpec {
  describe("Person Class") {
    it("has a first name and last name") {
      val JoeBloggs = new Person("Joe", "Bloggs")
      assert(JoeBloggs.sFirst == "Joe")
      assert(JoeBloggs.sLast == "Bloggs")
    }
    it("can set a name using Person.apply") {
      val AlfSmith: Person = Person.apply("Alfred Smith")
      assert(AlfSmith.sFirst == "Alfred")
      assert(AlfSmith.sLast == "Smith")
    }
    it("can handle more than two space separated names in String parameter to apply") {
      val AlfSmith: Person = Person.apply("Alfred John Smith")
      assert(AlfSmith.sFirst == "Alfred John")
      assert(AlfSmith.sLast == "Smith")
    }
  }

}
