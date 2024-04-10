package br.com.thiagozupelli.appcheckpoint02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definindo os botões por meio da obtenção dos ID's individuais
        val buttonCalculator = findViewById<Button>(R.id.buttonCalculator)
        val buttonPhone = findViewById<Button>(R.id.buttonPhone)
        val buttonSignature = findViewById<Button>(R.id.buttonSignature)

        // Definindo ações de acordo com o tap em cada botão
        buttonCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        buttonPhone.setOnClickListener {
            val intent = Intent(this, PhoneBillActivity::class.java)
            startActivity(intent)
        }

        buttonSignature.setOnClickListener {
            showStudentSignature()
        }
    }

    // Exibição da assinatura do desenvolvedor
    private fun showStudentSignature() {
        val signature = """
            Nome: Thiago Gameiro Zupelli
            RM: 99085
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Desenvolvido por:")
            .setMessage(signature)
            .setPositiveButton("Ok") { dialog, which -> }
            .show()
    }
}