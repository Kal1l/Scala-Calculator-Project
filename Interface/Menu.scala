package Interface
import scala.io.StdIn.*
import Operacoes.*

/*Fazer o Acumulador receber os resultados das operações desejadas
  Criar o histórico de operações
  Criar o método para limpar a entrada
  Importar os objetos que realizam as operações*/

object Menu extends Exception{
  var acumulador = 0
  var flag=true
  while(flag) {
    if(acumulador==0) {
      println("SELECIONE A AÇÃO DESEJADA:")
      println("1 - Operações básicas")
      println("2 - Operações Avançadas:")
      println("3- Histórico de Operações(10 últimas):")
      println("4 - Limpar entrada")
      println("5 -Sair")
    }else{
      Println("Resultado: " + acumulador)

      println("SELECIONE A AÇÃO DESEJADA:")
      println("1 - Operações básicas")
      println("2 - Operações Avançadas:")
      println("3- Histórico de Operações(10 últimas):")
      println("4 - Limpar entrada")
      println("5 -Sair")
    }
    try{
      var x=readInt();
    }catch {
      case e=>NumberFormatException("INSIRA VALOR VÁLIDO")
    }


  }
}
