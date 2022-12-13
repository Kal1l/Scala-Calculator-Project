package Operacoes

import scala.io.StdIn.*
import CalculosOO.*

//Inspirado no código de Mark Lewis https://www.youtube.com/playlist?list=PL9q7eWixkuxWo1LaXrI-SMhajPPdyUGjc
object ResolveExpressao {
  def eval(expr:String) :Double={
    var i = expr.length-1 //strinig(expressão) invertida
    var parensCount =0  //contador de parênteses
      var opLoc = -1  //localiza operação
      while (i>0) {
        if (expr(i) == ')') parensCount += 1
        else if (expr(i) == '(') parensCount -= 1
          //prioridade mais baixa
        else if (parensCount == 0 && (expr(i) == '+' || expr(i) == '-')) {
          opLoc = i
          //encontrando o sinal de bais baixa prioridade
          i = -1
        } else if (parensCount == 0 && opLoc < 0 && (expr(i) == '*' || expr(i) == '/' || expr(i) == '%')){
          opLoc = i
        } else if (parensCount == 0 && opLoc < 0 && (expr(i) == 'p'||expr(i) == 'r')) {
          opLoc = i
          //prioridade mais alta
        } else if (parensCount == 0 && opLoc < 0 && (expr(i) == 'l' || expr(i) == '!') || expr(i) =='s' || expr(i) =='c' || expr(i)== 't'){
          opLoc = i
        }
        i -= 1
    }
    if(opLoc<0){
      //prioridade de parênteses
      if(expr.trim()(0)=='('){
        eval(expr.trim.substring(1,expr.length-1))
        //transforma um número
      } else{
        expr.toDouble
      }
    }else{
      //encontrando os operadores para realizar os cálculos
      expr(opLoc) match{
        case '+' => CalculosOO.soma(eval(expr.substring(0,opLoc)),eval(expr.substring(opLoc+1)))//soma
        case '-' => CalculosOO.sub(eval(expr.substring(0,opLoc)),eval(expr.substring(opLoc+1)))//subtração
        case '*' => CalculosOO.mult(eval(expr.substring(0,opLoc)),eval(expr.substring(opLoc+1)))  //multiplicação
        case '/' => CalculosOO.div(eval(expr.substring(0,opLoc)),eval(expr.substring(opLoc+1))) //divisão
        case '%' => CalculosOO.mod(eval(expr.substring(0,opLoc)),eval(expr.substring(opLoc+1))) //módulo
        case 'p'=> CalculosOO.pow(eval(expr.substring(0,opLoc)),eval(expr.substring(opLoc+1))) // potenciação
        case 'r'=> CalculosOO.sqrt(eval(expr.substring(0,opLoc))) //raiz quadrada
        case 'l'=> CalculosOO.ln(eval(expr.substring(0,opLoc))) //logaritmo  natural
        case '!' => CalculosOO.fat(eval(expr.substring(0,opLoc)))  //fatorial
        case 's'=> CalculosOO.sin(eval(expr.substring(0,opLoc))) //seno
        case 'c'=> CalculosOO.cos(eval(expr.substring(0,opLoc))) //cosseno
        case 't'=> CalculosOO.tg(eval(expr.substring(0,opLoc)))  //tangente
      }
    }
  }
}