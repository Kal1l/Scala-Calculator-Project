package holanda

import scala.io.StdIn._
import scala.math._

private class Basics(globalNumber: Double) {

  def sum(): Double =
    if(globalNumber != 0.0)
      print("Insira y: ")
      val b = readDouble()
      val soma = globalNumber + b
      return soma

    else
      print("Insira x: ")
    val a = readDouble()
    print("Insira y: ")
    val b = readDouble()
    val soma = a + b
    return soma

  def sub(): Double =
    if(globalNumber != 0.0)
      print("Insira y: ")
      val b = readDouble()
      val subt = globalNumber - b
      return subt

    else
      print("Insira x: ")
    val a = readDouble()
    print("Insira y: ")
    val b = readDouble()
    val subt = a - b
    return subt

  def mult(): Double =
    if (globalNumber != 0.0)
      print("Insira y: ")
      val b = readDouble()
      val mul = globalNumber * b
      return mul

    else
      print("Insira x: ")
    val a = readDouble()
    print("Insira y: ")
    val b = readDouble()
    val mul = a * b
    return mul

  def div(): Double =
    if (globalNumber != 0.0)
      print("Insira y: ")
      val b = readDouble()
      val divs = globalNumber / b
      return divs

    else
      print("Insira x: ")
    val a = readDouble()
    print("Insira y: ")
    val b = readDouble()
    val divs = a / b
    return divs

  def mod(): Double =
    if (globalNumber != 0.0)
      print("Insira y: ")
      val b = readDouble()
      val modul = globalNumber % b
      return modul

    else
      print("Insira x: ")
    val a = readDouble()
    print("Insira y: ")
    val b = readDouble()
    val modul = a % b
    return modul

  def seno(): Double =
    if(globalNumber != 0.0)
      val valor = sin(globalNumber)
      return valor

    else
      print("Insira x:")
      val a = readDouble()
      val valor = sin(a)
      return valor

  def aSeno(): Double =
    if (globalNumber != 0.0)
      val valor = asin(globalNumber)
      return valor

    else
      print("Insira x:")
      val a = readDouble()
      val valor = asin(a)
      return valor

  def cosseno(): Double =
    if (globalNumber != 0.0)
      val valor = cos(globalNumber)
      return valor

    else
      print("Insira x:")
      val a = readDouble()
      val valor = cos(a)
      return valor

  def aCosseno(): Double =
      if (globalNumber != 0.0)
        val valor = acos(globalNumber)
        return valor

      else
        print("Insira x:")
        val a = readDouble()
        val valor = acos(a)
        return valor

  def tangente(): Double =
    if (globalNumber != 0.0)
      val valor = tan(globalNumber)
      return valor

    else
      print("Insira x:")
      val a = readDouble()
      val valor = tan(a)
      return valor

  def aTangente(): Double =
    if (globalNumber != 0.0)
      val valor = atan(globalNumber)
      return valor

    else
      print("Insira x:")
      val a = readDouble()
      val valor = atan(a)
      return valor

}