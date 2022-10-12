package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import ipca.example.calculator.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var userIsInTheMiddleOfIntroduction = false
    var calculatorBrain = CalculatorBrain()

    val onButtonNumPressed : ((View)->Unit)? = {
        val buttonPressed = it as? Button
        val charPressed : String = buttonPressed?.text.toString()
        var displayText = binding.textViewDisplay.text.toString()

        if (userIsInTheMiddleOfIntroduction){
            if (displayText == "0" && charPressed != "." ){
                binding.textViewDisplay.text = charPressed
            }else{
                if (charPressed == "." && !displayText.contains(".")) {
                    binding.textViewDisplay.text = displayText + charPressed
                }else if (charPressed != "."){
                    binding.textViewDisplay.text = displayText + charPressed
                }
            }
        }else {
            binding.textViewDisplay.text = charPressed
            userIsInTheMiddleOfIntroduction = true
        }

    }

    val onButtonOperationPressed : ((View)->Unit)? = { opPressed ->
        val buttonPressed = opPressed as? Button
        val displayText = binding.textViewDisplay.text.toString()

        calculatorBrain.operand = displayText.toDouble()
        calculatorBrain.operation = when (buttonPressed?.text.toString()){
            "+" -> Operation.SUM
            "-" -> Operation.SUBTRACTION
            "x" -> Operation.MULTIPLICATION
            "/" -> Operation.DIVISION
            else -> null
        }

        userIsInTheMiddleOfIntroduction = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(onButtonNumPressed)
        binding.button2.setOnClickListener(onButtonNumPressed)
        binding.button3.setOnClickListener(onButtonNumPressed)
        binding.button4.setOnClickListener(onButtonNumPressed)
        binding.button5.setOnClickListener(onButtonNumPressed)
        binding.button6.setOnClickListener(onButtonNumPressed)
        binding.button7.setOnClickListener(onButtonNumPressed)
        binding.button8.setOnClickListener(onButtonNumPressed)
        binding.button9.setOnClickListener(onButtonNumPressed)
        binding.button0.setOnClickListener(onButtonNumPressed)
        binding.buttonDot.setOnClickListener(onButtonNumPressed)

        binding.buttonPlus.setOnClickListener(onButtonOperationPressed)
        binding.buttonMinus.setOnClickListener(onButtonOperationPressed)
        binding.buttonMultiply.setOnClickListener(onButtonOperationPressed)
        binding.buttonDivision.setOnClickListener(onButtonOperationPressed)

        binding.buttonEqual.setOnClickListener {
            val displayValue = binding.textViewDisplay.text.toString().toDouble()
            var result = calculatorBrain.doOperation(displayValue)

            binding.textViewDisplay.text = if ( (result!! % 1) == 0.0 ){
                result.toInt().toString()
            }else{
                result.toString()
            }

            userIsInTheMiddleOfIntroduction = false
        }

    }


}