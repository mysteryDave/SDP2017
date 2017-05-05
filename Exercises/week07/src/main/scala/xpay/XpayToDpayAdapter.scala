package xpay

/**
  * Created by dtucke03 on 05/05/2017.
  */
class XpayToDpayAdapter extends Xpay {
  val payDLink: PayDImpl = new PayDImpl

  def getCreditCardNo: String = payDLink.getCustCardNo

  def setCreditCardNo(creditCardNo: String): Unit = {
    payDLink.setCustCardNo(creditCardNo)
  }

  def getCustomerName: String = payDLink.getCardOwnerName

  def setCustomerName(customerName: String): Unit = {
    payDLink.setCardOwnerName(customerName)
  }

  def getCardExpMonth: String = {
    val sDate = payDLink.getCardExpMonthDate
    if (sDate == null || "??" == sDate.dropRight(2)) null
    else sDate.dropRight(2)
  }

  def setCardExpMonth(cardExpMonth: String): Unit = {
    val sCardDate = payDLink.getCardExpMonthDate
    if (getCardExpYear == null) payDLink.setCardExpMonthDate(cardExpMonth + "??")
    else payDLink.setCardExpMonthDate(cardExpMonth + getCardExpYear)
  }

  def getCardExpYear: String = {
    val sDate = payDLink.getCardExpMonthDate
    if (sDate == null || "??" == sDate.drop(2)) (null)
    else sDate.drop(2)
  }

  def setCardExpYear(cardExpYear: String): Unit = {
    val sCardDate = payDLink.getCardExpMonthDate
    if (getCardExpMonth == null) payDLink.setCardExpMonthDate("??" + cardExpYear)
    else payDLink.setCardExpMonthDate(getCardExpMonth + cardExpYear)
  }

  def getCardCVVNo: Short = payDLink.getCVVNo.toShort

  def setCardCVVNo(cardCVVNo: Short): Unit = {
    payDLink.setCVVNo(cardCVVNo.toInt)
  }

  def getAmount: Double = payDLink.getTotalAmount

  def setAmount(amount: Double): Unit = {
    payDLink.setTotalAmount(amount)
  }
}
