package Interface
import scala.io.StdIn.*
import Operacoes.*
import scala.collection.mutable.ListBuffer

/*Importar os objetos que realizam as operações*/

object Menu extends Exception{

  def main(args: Array[String]): Unit = {
    var acumulador = 0.0
    var flag = true
    var historico = ListBuffer[String]()

    while (flag) {
      if (acumulador == 0) {
        println("SELECIONE A AÇÃO DESEJADA:")
        println("1 - Operações básicas (+ - * /)")
        println("2 - Operações Avançadas")
        println("3 - Histórico de Operações(10 últimas)")
        println("4 - Limpar entrada")
        println("5 - Sair")
      } else {
        println("SELECIONE A AÇÃO DESEJADA:")
        println("1 - Operações básicas")
        println("2 - Operações Avançadas:")
        println("3 - Histórico de Operações(10 últimas):")
        println("4 - Limpar entrada")
        println("5 -Sair")
        println("Resultado: " + acumulador)
      }
      val input=readLine()
      input match {
        case "1" => val valor = ResolveExpressao
          if(acumulador==0){
            println("Digite a expressão: ")
            val result = readLine()
            acumulador = valor.eval(result)
            val aux = result
            historico += s"$aux = $acumulador"
          }else{
            printf(f"Digite a expressão: $acumulador")
            val aux = acumulador
            val result = readLine()
            val expr = s"$acumulador" + s"$result"
            acumulador = valor.eval(expr)
            val aux2 = result
            historico += s"$aux $aux2 = $acumulador"
          }
        case "2" =>
          println("SELECIONE A OPERACAO:")
          println("1 - Potencia(x,y)")
          println("2 - Raiz Quadrada(x)")
          println("3 - Logaritmo Natural(x)")
          println("4 - Fatorial(x)")
          println("5 - Seno(x)")
          println("6 - Cosseno(x)")
          println("7 - Tangente(x)")
          val inputOp = readLine()

          inputOp match{
            case "1"=>
              if(acumulador==0){
                printf(f"Digite x:")
                val x = readDouble()
                printf(f"Digite y:")
                val y = readDouble()
                val result = CalculosOO.pow(x, y)
                historico += s"pow{$x,$y} = $result"
                acumulador = result
              }else{
                println(f"Digite x: $acumulador")
                val x = acumulador
                printf(f"Digite y:")
                val y = readDouble()
                val result = CalculosOO.pow(x, y)
                historico += s"pow{$x,$y} = $result"
                acumulador = result
              }
            case "2"=>
              printf(f"Digite x: ")
              val x = readDouble()
              val result = CalculosOO.sqrt(x)
              historico += s"sqrt{$x} = $result"
              acumulador = result
            case "3"=>
              printf(f"Digite x: ")
              val x=readDouble()
              val result = CalculosOO.ln(x)
              historico += s"ln{$x} = $result"
              acumulador = result
            case "4"=>
              printf(f"Digite x: ")
              val x=readDouble()
              val result=CalculosOO.fat(x)
              historico += s"$x! = $result"
              acumulador = result
            case "5"=>
              printf(f"Digite x: ")
              val x=readDouble()
              val result=CalculosOO.sin(x)
              historico += s"sin{$x} = $result"
              acumulador = result
            case "6"=>
              printf(f"Digite x: ")
              val x=readDouble()
              val result=CalculosOO.cos(x)
              historico += s"cos{$x} = $result"
              acumulador = result
            case "7"=>
              printf(f"Digite x: ")
              val x=readDouble()
              val result=CalculosOO.tg(x)
              historico += s"tg{$x} = $result"
              acumulador = result
            case _ => println("OPERACAO INVALIDA")
            }
        case "3" => val lista = historico.toList.take(10)
          for (l <- lista)
            println(l)
        case "4" => acumulador = 0.0
        case "5" => println("ENCERRANDO")
          flag = false
        case _ => println("INSIRA VALOR VÁLIDO")
      }
    }
  }
}