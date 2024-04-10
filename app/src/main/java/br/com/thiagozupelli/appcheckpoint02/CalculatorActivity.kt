package br.com.thiagozupelli.appcheckpoint02

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // Capturando os elementos por ID
        val editableValue1 = findViewById<EditText>(R.id.textValue1)
        val editableValue2 = findViewById<EditText>(R.id.textValue2)
        val radioOperations = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        // Validação dos tipos de dado no campo, com conversão para double
        buttonCalculate.setOnClickListener {
            val value1 = editableValue1.text.toString().toDoubleOrNull()
            val value2 = editableValue2.text.toString().toDoubleOrNull()

            // Tratativa de erro para que não tenha campos vazios nos dados de "valor"
            if (value1 == null || value2 == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // When com identificação da opção selecionada no Radio Group
            val result = when (radioOperations.checkedRadioButtonId) {
                R.id.radioSum -> value1 + value2
                R.id.radioSubtraction -> value1 - value2
                R.id.radioMultiplication -> value1 * value2
                R.id.radioDivision -> if (value2 != 0.0) {value1/value2} else "Impossível executar divisão por zero."
                else -> null
            }

            // Condicional para divisão por 0, com exibição do erro ao usuário
            if (result == null) {
                Toast.makeText(this, "Operação inválida.", Toast.LENGTH_SHORT).show()
            } else if (result.equals(R.id.radioDivision) || value2 == 0.0) {
                Toast.makeText(this, "Erro: $result", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Resultado: $result", Toast.LENGTH_SHORT).show()
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Evento no botão de voltar para a barra de ação
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
