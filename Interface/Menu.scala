package Interface
import scala.io.StdIn.*
import Operacoes.*
import scala.collection.mutable.ListBuffer

/*Fazer o Acumulador receber os resultados das operações desejadas
  Criar o histórico de operações
  Criar o método para limpar a entrada
  Importar os objetos que realizam as operações*/

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
        println("3- Histórico de Operações(10 últimas)")
        println("4 - Limpar entrada")
        println("5 - Sair")
        var x = readInt()

        x match {
          case 1 => val valor = ResolveExpressao
            println("Digite a expressão: ")
            val result = readLine()
            val aux = result
            acumulador = valor.eval(result)
            historico += s"$aux = $acumulador"
          case 3 => val lista = historico.toList.take(10)
            for (l <- lista)
              println(l)
          case 5 => println("Até logo!")
            flag = false
          case _ => println("Digite um valor válido!")
        }

      } else {
        println("Resultado: " + acumulador)

        println("SELECIONE A AÇÃO DESEJADA:")
        println("1 - Operações básicas")
        println("2 - Operações Avançadas:")
        println("3- Histórico de Operações(10 últimas):")
        println("4 - Limpar entrada")
        println("5 -Sair")

        var x = readInt()

        x match {
          case 1 => val valor = ResolveExpressao
            println("Digite a expressão: ")
            val result = readLine()
            val aux = result
            acumulador = valor.eval(result)
            historico += s"$aux = $acumulador"
          case 3 => val lista = historico.toList.take(10)
            for (l <- lista)
              println(l)
          case 4 => acumulador = 0.0
          case 5 => println("Até logo!")
            flag = false
          case _ => println("Digite um valor válido!")
        }
      }
      try {
        var x = readInt();
      } catch {
        case e => NumberFormatException("INSIRA VALOR VÁLIDO")
      }
    }
  }
}
