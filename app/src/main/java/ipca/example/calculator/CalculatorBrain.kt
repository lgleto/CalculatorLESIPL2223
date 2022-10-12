package ipca.example.calculator

enum class Operation(val op:String) {
    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("x"),
    DIVISION("/")
}

class CalculatorBrain {

    var operand = 0.0
    var operation : Operation? = null

    fun doOperation( op2 : Double) : Double? {
        var result = when (operation) {
            Operation.SUM -> operand + op2
            Operation.SUBTRACTION -> operand - op2
            Operation.MULTIPLICATION -> operand * op2
            Operation.DIVISION -> operand / op2
            else -> null
        }
        return result
    }

}