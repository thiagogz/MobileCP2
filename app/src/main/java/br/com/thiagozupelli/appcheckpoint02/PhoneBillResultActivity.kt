package br.com.thiagozupelli.appcheckpoint02

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhoneBillResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phonebillresult)

        // Retorno dos valores previamente armazenados, com valor base '0.0' para evitar erro de exibição
        val tax = intent.getDoubleExtra("taxa", 0.0)
        val result1 = intent.getDoubleExtra("resultado1", 0.0)
        val result2 = intent.getDoubleExtra("resultado2", 0.0)

        val total = tax + result1 + result2

        // Captura da textView com formatação para o valor em real
        val resultView = findViewById<TextView>(R.id.resultView)
        resultView.text = String.format("Assinatura: R$ %.2f\n" +
                "Chamada Local: R$ %.2f\n" +
                "Chamada Celular: R$ %.2f\n\n" +
                "Total: R$ %.2f", tax, result1, result2, total)

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
