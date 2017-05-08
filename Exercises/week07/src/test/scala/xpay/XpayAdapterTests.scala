package xpay

/**
  * Created by dtucke03 on 05/05/2017.
  */
class XpayAdapterTests extends org.scalatest.FunSpec {
  describe("Identical behaviour between Xpay and XpayToDpayAdapter") {
    it("has same Credit Card No") {
      val egCardNo: String = "1234567890123456"
      val oldX: Xpay = new XpayImpl
      val newA: XpayToDpayAdapter = new XpayToDpayAdapter
      assert(oldX.getCreditCardNo == newA.getCreditCardNo)
      oldX.setCreditCardNo(egCardNo)
      newA.setCreditCardNo(egCardNo)
      assert(oldX.getCreditCardNo == newA.getCreditCardNo)
      assert(oldX.getCreditCardNo == egCardNo)
      assert(newA.getCreditCardNo == egCardNo)
    }

    it("has same Customer Name") {
      val egCust: String = "Mr Joeseph Bloggs"
      val oldX: Xpay = new XpayImpl
      val newA: XpayToDpayAdapter = new XpayToDpayAdapter
      assert(oldX.getCustomerName == newA.getCustomerName)
      oldX.setCustomerName(egCust)
      newA.setCustomerName(egCust)
      assert(oldX.getCustomerName == newA.getCustomerName)
      assert(oldX.getCustomerName == egCust)
      assert(newA.getCustomerName == egCust)
    }

    it("has same Card Exp Month") {
      val egMonth: String = "05"
      val oldX: Xpay = new XpayImpl
      val newA: XpayToDpayAdapter = new XpayToDpayAdapter
      assert(oldX.getCardExpMonth == newA.getCardExpMonth)
      newA.setCardExpYear("21")
      newA.setCardExpYear("20")
      assert(oldX.getCardExpMonth == newA.getCardExpMonth)
      oldX.setCardExpMonth(egMonth)
      newA.setCardExpMonth(egMonth)
      assert(oldX.getCardExpMonth == newA.getCardExpMonth)
      newA.setCardExpYear("19")
      assert(oldX.getCardExpMonth == newA.getCardExpMonth)
      assert(oldX.getCardExpMonth == egMonth)
      assert(newA.getCardExpMonth == egMonth)
    }

    it("has same Card Exp Year") {
      val egYear: String = "22"
      val oldX: Xpay = new XpayImpl
      val newA: XpayToDpayAdapter = new XpayToDpayAdapter
      assert(oldX.getCardExpYear == newA.getCardExpYear)
      newA.setCardExpMonth("09")
      newA.setCardExpMonth("10")
      assert(oldX.getCardExpYear == newA.getCardExpYear)
      oldX.setCardExpYear(egYear)
      newA.setCardExpYear(egYear)
      assert(oldX.getCardExpYear == newA.getCardExpYear)
      newA.setCardExpMonth("11")
      assert(oldX.getCardExpYear == newA.getCardExpYear)
      assert(oldX.getCardExpYear == egYear)
      assert(newA.getCardExpYear == egYear)
    }

    it("has same Card CCV No") {
      val egCVV: Short = 123
      val oldX: Xpay = new XpayImpl
      val newA: XpayToDpayAdapter = new XpayToDpayAdapter
      assert(oldX.getCardCVVNo == newA.getCardCVVNo)
      oldX.setCardCVVNo(egCVV)
      newA.setCardCVVNo(egCVV)
      assert(oldX.getCardCVVNo == newA.getCardCVVNo)
      assert(oldX.getCardCVVNo == egCVV)
      assert(newA.getCardCVVNo == egCVV)
    }

    it("has same Amount") {
      val egAmount: Double = 123.45
      val oldX: Xpay = new XpayImpl
      val newA: XpayToDpayAdapter = new XpayToDpayAdapter
      assert(oldX.getAmount == newA.getAmount, 0.01)
      oldX.setAmount(egAmount)
      newA.setAmount(egAmount)
      assert(oldX.getAmount == newA.getAmount, 0.01)
      assert(oldX.getAmount == egAmount, 0.01)
      assert(newA.getAmount == egAmount, 0.01)
    }
  }

}
