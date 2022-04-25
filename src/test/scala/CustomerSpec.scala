import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CustomerSpec extends AnyFlatSpec with should.Matchers{
  val kantor = Kantor("cinckciarz")
  val customer = Customer("Michał","Lato", kantor.rates)
  "function addAcc" should "add acc to list" in {
    customer.addAcc(Account("euro", 5000))
    customer.accLs.size shouldBe 1
  }
  "function transfer" should "transfer money with rates in mind e => d" in{
    val cust = Account("dollar",0)

    customer.transfer(Account("euro",1),1,cust)
    cust.accBalance shouldBe 1.08

  }
  it should "transfer money with rates in mind e => e" in{
    val cust = Account("euro",0)

    customer.transfer(Account("euro",1),1,cust)
    cust.accBalance shouldBe 1
  }
  it should "transfer money with rates in mind e=> p" in{
    val cust = Account("pound",0)

    customer.transfer(Account("euro",1),1,cust)
    cust.accBalance shouldBe 0.84
  }
  it should "transfer money with rates in mind p=> p" in{
    val cust = Account("pound",0)

    customer.transfer(Account("pound",1),1,cust)
    cust.accBalance shouldBe 1
  }
  it should "transfer money with rates in mind p=> d" in{
    val cust = Account("dollar",0)

    customer.transfer(Account("pound",1),1,cust)
    cust.accBalance shouldBe 1.28
  }
  it should "transfer money with rates in mind d=> p" in{
    val cust = Account("pound",0)

    customer.transfer(Account("dollar",1),1,cust)
    cust.accBalance shouldBe 0.78
  }
  it should "transfer money with rates in mind d=> e" in{
    val cust = Account("euro",0)

    customer.transfer(Account("dollar",1),1,cust)
    cust.accBalance shouldBe 0.93
  }
 }
