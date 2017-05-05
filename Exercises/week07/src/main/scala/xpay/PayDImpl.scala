package xpay

/**
  * Created by dtucke03 on 05/05/2017.
  */

class PayDImpl extends PayD {
  private var custCardNo: String = null
  private var cardOwnerName: String = null
  private var cardExpMonthDate: String = null
  private var cVVNo: Integer = 0
  private var totalAmount: Double = .0

  def getCustCardNo: String = custCardNo

  def setCustCardNo(custCardNo: String) {
    this.custCardNo = custCardNo
  }

  def getCardOwnerName: String = cardOwnerName

  def setCardOwnerName(cardOwnerName: String) {
    this.cardOwnerName = cardOwnerName
  }

  def getCardExpMonthDate: String = cardExpMonthDate

  def setCardExpMonthDate(cardExpMonthDate: String) {
    this.cardExpMonthDate = cardExpMonthDate
  }

  def getCVVNo: Integer = cVVNo

  def setCVVNo(cVVNo: Integer) {
    this.cVVNo = cVVNo
  }

  def getTotalAmount: Double = totalAmount

  def setTotalAmount(totalAmount: Double): Unit = {
    this.totalAmount = totalAmount
  }

}
