package Operacoes
import scala.io.StdIn.*
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
}

object CalculosOO {

  class OverflowException extends RuntimeException("Valor muito alto")
  class UnderflowException extends RuntimeException("Valor muito baixo")
  class ZeroDivisionException extends RuntimeException("Divisão por 0")

  def soma(x: Double, y: Double): Double = {
    val resultado = x + y

    if (x > 0 && y > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && y < 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def sub(x: Double, y: Double): Double = {
    val resultado = x - y

    if (x > 0 && y > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && y < 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def mult(x: Double, y: Double): Double = {
    val resultado = x * y

    if (x > 0 && y > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && y < 0 && resultado < 0) throw new OverflowException
    else if (x > 0 && y < 0 && resultado > 0) throw new UnderflowException
    else if (x < 0 && y > 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def div(x: Double, y: Double): Double = {
    if (y == 0) throw new ZeroDivisionException
    else return x / y
  }

  def mod(x: Double, y: Double): Double = {
    if (y == 0) throw new ZeroDivisionException
    else return x % y
  }

  def pow(x: Double, y: Double): Double = {
    val resultado = scala.math.pow(x, y)

    if (x < 0 && y % 2 == 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && y % 2 != 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def sqrt(x: Double): Double = {
    val resultado = scala.math.sqrt(x)
    if (x < 0) throw new RuntimeException("Raiz Negativa")
    else return resultado
  }

  def ln(x: Double): Double = {
    val resultado = scala.math.log(x)
    if (x < 0) throw new RuntimeException("Logaritmo Negativo")
    else return resultado
  }

  def fat(x: Double): Double = {
    val resultado = {
      if (x == 1) return x
      else return x * fat(x - 1)
    }
    if(x<0) throw new RuntimeException("Fatorial Negativa")
    else return resultado
  }

  def sin(x: Double): Double = {
    val resultado = scala.math.sin(x)

    if (x > 0  && resultado < 0) throw new OverflowException
    else if (x < 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def cos(x: Double): Double = {
    val resultado = scala.math.cos(x)

    if (x > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }

  def tg(x: Double): Double = {
    val resultado = scala.math.tan(x)

    if (x > 0 && resultado < 0) throw new OverflowException
    else if (x < 0 && resultado > 0) throw new UnderflowException
    else return resultado
  }
}
