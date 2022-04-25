import scala.collection.mutable.ListBuffer

case class Customer(name: String,lastName: String, rates: List[Double]){
  val accLs = new ListBuffer[Account]
  def addAcc(account: Account) ={
    accLs += account
  }
  def transfer(acc1: Account,amount: Double,acc2: Account)={
    acc1.currency match {
      case "euro" => acc2.currency match {
        case "euro" => {
          acc1.accBalance -= amount
          acc2.accBalance += amount
        }
        case "dollar" =>{
          {
            acc1.accBalance -= amount
            acc2.accBalance += amount*rates(0)
          }
        }
        case "pound" =>{
          {
            acc1.accBalance -= amount
            acc2.accBalance += amount*rates(2)
          }
        }
      }
      case "dollar" => acc2.currency match{
        case "euro" => {
          acc1.accBalance -= amount
          acc2.accBalance += amount*rates(1)
        }
        case "dollar" =>{
          {
            acc1.accBalance -= amount
            acc2.accBalance += amount
          }
        }
        case "pound" =>{
          {
            acc1.accBalance -= amount
            acc2.accBalance += amount*rates(5)
          }
        }
      }
      case "pound" => acc2.currency match{
        case "euro" => {
          acc1.accBalance -= amount
          acc2.accBalance += amount*rates(3)
        }
        case "dollar" =>{
          {
            acc1.accBalance -= amount
            acc2.accBalance += amount * rates(4)
          }
        }
        case "pound" =>{
          {
            acc1.accBalance -= amount
            acc2.accBalance += amount
          }
        }
      }
    }
  }
}
