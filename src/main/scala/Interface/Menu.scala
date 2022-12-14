package Interface
import scala.io.StdIn.*
import Operacoes.*
import scala.collection.mutable.ListBuffer


object Menu extends Exception{

  def main(args: Array[String]): Unit = {
    var acumulador = 0.0
    var flag = true
    var historico = ListBuffer[String]()
    /* Listas em Scala são imutáveis, um claro sinal do paradigma funcional
       então para casos onde queremos listas que serão constantemente modificadas
       é comum utilizar o ListBuffer para criar listas modificáveis
    */

    while (flag) {
      if (acumulador == 0) {
        println("SELECIONE A AÇÃO DESEJADA:")
        println("1 - Calcular Expressão")
        println("2 - Histórico de Operações(10 últimas)")
        println("3 - Limpar entrada")
        println("4 - Utilizar PI (π)")
        println("5 - Utilizar Euler (e)")
        println("6 - Lista de operações")
        println("7 - Sair")
      } else {
        println("SELECIONE A AÇÃO DESEJADA:")
        println("1 - Calcular Expressão")
        println("2 - Histórico de Operações(10 últimas):")
        println("3 - Limpar entrada")
        println("4 - Utilizar PI (π)")
        println("5 - Utilizar Euler (e)")
        println("6 - Lista de operações")
        println("7 - Sair")
        println("Resultado: " + acumulador)
      }
      val input=readLine()
      input match {
        case "1" => val valor = ResolveExpressao
          if(acumulador==0){
            println("Digite a expressão: ")
            val result = readLine()
            try{
              acumulador = valor.eval(result)
            } catch {
              case e:NumberFormatException => println("Operador inválido")
            }
            val aux = result
            historico += s"$aux = $acumulador"
          }else{
            printf(f"Digite a expressão: $acumulador")
            val aux = acumulador
            val result = readLine()
            val expr = s"$acumulador" + s"$result"
            acumulador = valor.eval(expr)
            val aux2 = result
            historico += s"$aux$aux2 = $acumulador"
          }
        case "2" => val lista = historico.toList.take(10)
          for (l <- lista)
            println(l)
        case "3" => acumulador = 0.0
        case "4" => acumulador = 3.14159265359
        case "5" => acumulador = 2.7182818284590452353602874713527
        case "6" =>
          println("+ -> Somar | Ex: a+b")
          println("- -> Subtrair | Ex: a-b")
          println("* -> Multiplicar | Ex: a*b")
          println("/ -> Dividir | Ex: a/b")
          println("% -> Modulo | Ex: a%b")
          println("p -> Potenciação | Ex: 2p2 = 4")
          println("r -> Raiz Quadrada | Ex: 2r = 4")
          println("l - > Logaritmo | Ex: 2l = 0.69...")
          println("s-> Seno | Ex: 45s = 0.85...")
          println("c-> Cosseno | Ex: 45c = 0.52...")
          println("t-> Tangente | Ex: 45t = 1.61...")
          println("( -> Abre Parênteses")
          println(") -> Fecha Parênteses")
          println("OBS: Ao realizar uma operação lembre-se sempre de colocar o sinal APÓS o número")

        case "7" => println("ENCERRANDO")
          flag = false
        case _ => println("INSIRA VALOR VÁLIDO")
      }
    }
  }
}

