package Operacoes
import scala.io.StdIn.*
import scala.util.{Failure, Success, Try}
import scala.math.*

object CalculosFunc {
  val soma: (Double,Double) => Double = _+_
  val sub: (Double,Double) => Double = _-_
  val mult: (Double,Double) => Double = _*_
  val div: (Double,Double) => Double = _/_
  val mod: (Double,Double) => Double = _%_
  val sin:Double => Double = (x: Double) => scala.math.sin(x)
  val aSin:Double => Double = (x: Double) => scala.math.asin(x)
  val cos:Double => Double = (x: Double) => scala.math.cos(x)
  val aCos:Double => Double = (x: Double) => scala.math.acos(x)
  val tan:Double => Double = (x: Double) => scala.math.tan(x)
  val aTan:Double => Double = (x: Double) => scala.math.atan(x)
  val pow: (Double,Double) => Double = (x:Double,y:Double) => scala.math.pow(x,y)
  val log:Double => Double = (x: Double) => scala.math.log(x)
  val sqrt:Double => Double =(x: Double) => scala.math.sqrt(x)
  def fat(x: Int): BigInt = {
    if (x == 1)
      x
    else {
      x * fat(x - 1)
    }
  }
}

object CalculosOO{
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class ZeroDivisionException extends RuntimeException("Divisão por 0")

  def soma(x:Double ,y:Double): Double = {
    val resultado = x+y

    if(x>0 && y>0 && resultado < 0) throw new OverflowException
    else if (x<0 && y<0 && resultado >0) throw new UnderflowException
    else return resultado
  }

  def sub(x: Double, y: Double): Double = {
    val resultado = x - y

    if (x > 0 && y > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && y < 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def mult(x: Double, y: Double): Double = {
    val resultado = x - y

    if (x > 0 && y > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && y < 0 && resultado < 0) throw new OverflowException
    else if (x > 0 && y < 0 && resultado > 0) throw new UnderflowException
    else if (x < 0 && y > 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def div(x:Double,y:Double): Double = {
    if(y==0) throw new ZeroDivisionException
    else return x/y
  }

  def mod(x: Double, y: Double): Double = {
    if (y == 0) throw new ZeroDivisionException
    else return x % y
  }

  /*def pow(x:Double,y:Double): Double = {
    if(x%2==0 && result<0)
  }*/

}

object FakeMain extends App{
  printf(f"Insira x: ")
  private val x = readInt()
  private val resultado = CalculosFunc.fat(x)
  println(resultado)
}