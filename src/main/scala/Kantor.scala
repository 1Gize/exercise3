case class Kantor(s: String){
  val name = s
  val rates = List(
    1.08, //euro to dollar
    0.93, //dollar to euro
    0.84, //euro to pound
    1.19, //pound to euro
    1.28, //pound to dolar
    0.78) //dolar to pound
}
