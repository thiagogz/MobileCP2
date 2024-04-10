package br.com.thiagozupelli.appcheckpoint02

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PhoneBillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phonebill)

        // Capturando os elementos por ID
        val fixedValue = findViewById<EditText>(R.id.fixedText)
        val editableValue1 = findViewById<EditText>(R.id.textValue1)
        val editableValue2 = findViewById<EditText>(R.id.textValue2)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        // Configurando o evento no botão e transição de tela com inserção dos resultados para a página seguinte
        buttonCalculate.setOnClickListener {

            // Validação dos tipos de dado no campo, com conversão para double
            val tax = fixedValue.text.toString().toDoubleOrNull()
            val value1 = editableValue1.text.toString().toDoubleOrNull()
            val value2 = editableValue2.text.toString().toDoubleOrNull()

            // Tratativa de erro para que não tenha campos vazios nos dados de "valor"
            if (value1 == null || value2 == null || tax == null) {
                Toast.makeText(this, "Os campos de valor e taxa são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cálculo para os resultados das chamadas
            val result1 = value1 * 0.04
            val result2 = value2 * 0.20

            // Variável com valores armazenados para o retorno na tela seguinte, já com resultados
            val intent = Intent(this, PhoneBillResultActivity::class.java).apply {
                putExtra("taxa", tax)
                putExtra("resultado1", result1)
                putExtra("resultado2", result2)
            }
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Função para retorno de tela
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
