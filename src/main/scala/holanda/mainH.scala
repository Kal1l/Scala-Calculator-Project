package holanda

import scala.io.StdIn._
import holanda.*


@main def run(): Unit =
  var loop = true
  var globalNumber = 0.0

  while
    loop
  do
    println("1 para +")
    println("2 para -")
    println("3 para *")
    println("4 para /")
    println("5 para %")
    println("6 para reiniciar")
    println("7 para sair")
    println("")
    println("Resultado: " + globalNumber)

    var x = readInt()

    x match
      case 1 => val soma = Basics(globalNumber)
        globalNumber = soma.sum()

      case 2 => val subtracao = Basics(globalNumber)
        globalNumber = subtracao.sub()

      case 3 => val multiplicacao = Basics(globalNumber)
        globalNumber = multiplicacao.mult()

      case 4 => val divisao = Basics(globalNumber)
        globalNumber = divisao.div()

      case 5 => val modulo = Basics(globalNumber)
        globalNumber = modulo.mod()

      case 6 => globalNumber = 0.0

      case 7 => println("Até logo!")
        loop = false

      case _ => println("Por favor digite uma das operações")
