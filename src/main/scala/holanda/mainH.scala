package holanda

import scala.io.StdIn._
import holanda.*
import scala.collection.mutable.ListBuffer



@main def run(): Unit =
  var loop = true
  var globalNumber = 0.0
  var historico = ListBuffer[String]()


  while
    loop
  do
    println("1 para +")
    println("2 para -")
    println("3 para *")
    println("4 para /")
    println("5 para %")
    println("6 para ver histórico")
    println("7 para reiniciar")
    println("8 para sair")
    println("Resultado: " + globalNumber)

    var x = readInt()

    x match
      case 1 => val soma = Basics()
        if(globalNumber != 0.0)
          print("Insira y:")
          val b = readDouble()
          val aux = soma.sum(globalNumber, b)
          historico += s"$globalNumber + $b = $aux"
          globalNumber = aux
        else
          println("Insira x:")
          val a = readDouble()
          println("Insira y:")
          val b = readDouble()
          globalNumber = soma.sum(a, b)
          historico += s"$a + $b = $globalNumber"


      case 2 => val subtracao = Basics()
        if (globalNumber != 0.0)
          print("Insira y:")
          val b = readDouble()
          val aux = subtracao.sub(globalNumber, b)
          historico += s"$globalNumber - $b = $aux"
          globalNumber = aux
        else
          println("Insira x:")
          val a = readDouble()
          println("Insira y:")
          val b = readDouble()
          globalNumber = subtracao.sub(a, b)
          historico += s"$a - $b = $globalNumber"

      case 3 => val multiplicacao = Basics()
        if (globalNumber != 0.0)
          print("Insira y:")
          val b = readDouble()
          val aux = multiplicacao.mult(globalNumber, b)
          historico += s"$globalNumber * $b = $aux"
          globalNumber = aux
        else
          println("Insira x:")
          val a = readDouble()
          println("Insira y:")
          val b = readDouble()
          globalNumber = multiplicacao.mult(a, b)
          historico += s"$a * $b = $globalNumber"

      case 4 => val divisao = Basics()
        if (globalNumber != 0.0)
          print("Insira y:")
          val b = readDouble()
          val aux = divisao.div(globalNumber, b)
          historico += s"$globalNumber / $b = $aux"
          globalNumber = aux
        else
          println("Insira x:")
          val a = readDouble()
          println("Insira y:")
          val b = readDouble()
          globalNumber = divisao.div(a, b)
          historico += s"$a / $b = $globalNumber"

      case 5 => val modulo = Basics()
        if (globalNumber != 0.0)
          print("Insira y:")
          val b = readDouble()
          val aux = modulo.mod(globalNumber, b)
          historico += s"$globalNumber / $b = $aux"
          globalNumber = aux
        else
          println("Insira x:")
          val a = readDouble()
          println("Insira y:")
          val b = readDouble()
          globalNumber = modulo.mod(a, b)
          historico += s"$a / $b = $globalNumber"

      case 6 => val lista = historico.toList.take(10)
        println("Histórico (últimas 10 operações)")
        for (l <- lista)
          println(l)

      case 7 => globalNumber = 0.0

      case 8 => println("Até logo!")
        loop = false

      case _ => println("Por favor digite uma das operações")
