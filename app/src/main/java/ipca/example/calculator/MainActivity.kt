package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ipca.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

       binding.button1.setOnClickListener {
           binding.textViewDisplay.text = "1"
       }

        binding.button2.setOnClickListener {
            binding.textViewDisplay.text = "2" + binding.textViewDisplay.text.toString()
        }
    }


}