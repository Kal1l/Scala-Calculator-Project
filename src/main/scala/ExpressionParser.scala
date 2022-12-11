import scala.io.StdIn.*
import scala.swing._

class UI extends MainFrame {
  title = "Calculadora"
  contents = new GridPanel(2, 2){
  contents += new Button("Calcular")
  contents += new Button("Histórico")
  contents += new Button("Limpar Entrada")
  contents += new Button("Fechar")

}}


object ExpressionParser {

  private def eval(expr:String,vars:Map[String,Double]) :Double={
    var i = expr.length-1
    var parensCount = 0
    var opLoc = -1
    while(i>0){
      if(expr(i)==')') parensCount += 1
      else if(expr(i)=='(') parensCount -= 1
      else if(parensCount==0 &&(expr(i)=='+'||expr(i)=='-')){
        opLoc = i
        i= -1
      } else if(parensCount==0 && opLoc<0 && (expr(i)=='*'||expr(i)=='/')){
        opLoc = i
      }
      i -= 1
    }
    if(opLoc<0){
      if(expr.trim()(0)=='('){
        eval(expr.trim.substring(1,expr.length-1),vars)
      }else if(vars.contains(expr))
        vars(expr)
      else{
        expr.toDouble
      }
    }else{
      expr(opLoc) match{
        case '+' => eval(expr.substring(0,opLoc),vars)+eval(expr.substring(opLoc+1),vars)
        case '-' => eval(expr.substring(0,opLoc),vars)-eval(expr.substring(opLoc+1),vars)
        case '*' => eval(expr.substring(0,opLoc),vars)*eval(expr.substring(opLoc+1),vars)
        case '/' => eval(expr.substring(0,opLoc),vars)/eval(expr.substring(opLoc+1),vars)
      }
    }
  }
  def main(args:Array[String]): Unit = {
    val ui = new UI
    ui.visible = true
    println("Digite o valor")
    val result=readLine()
    println(eval( result,Map("x"->2)))
  }
}
