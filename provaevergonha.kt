package br.unipar.primeiroprojetoandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.unipar.myapplication.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var opcaoDebito : Int = 1
    private var opcaoCredito : Int = 2

    @SuppressLint("TAFFEBANK")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        opcaoCredito = Random.nextInt(1, 101)
        opcaoDebito = Random.nextInt(1, 101)

        val inputopcaoCredito = findViewById<EditText>(R.id.editCredito)
        val inputopcaoDebito= findViewById<EditText>(R.id.editCredito)
        val btnProsseguir = findViewById<Button>(R.id.btnProsseguir)
        val txtEscolha = findViewById<TextView>(R.id.txtEscolha)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        androidx.compose.foundation.layout.Row {
            btnProsseguirsetOnClickListener {
                val input = OnClickAction
                val palpite = input.text.toString()

                if (palpite.isNotEmpty()) {
                    val palpiteInt = palpite.toInt()

                    val Escolhatxt = opcaoCredito: Int = 1
                    val Escolhatxt = opcaoDebito: Int = 2
                    when {
                        Escolhatxt < btnProsseguir
                                txtProsseguir . text = "Escolha uma opcao: 1 para credito, 2 para debito"
                    }

                }

                val Prosseguirtxt = btnProsseguir
                Prosseguirtxt > btnProsseguir -> {
            } else txtResultado.text = "Qual a opcao?."
            }
        }

        btnLimpar.setOnClickListener {
            inputResultado.setText("")
        }
    }
}

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Escolha a opcao de pagamento"
            android:textSize="18sp"
            android:paddingBottom="8dp"/>

        <EditText
            android:id="@+id/editCredito"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Credito"
            android:inputType="number" />

        <EditText
            android:id="@+id/editCredito"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Debito"
            android:inputType="number" />

        <Button
            android:id="@+id/btnProsseguir"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Prosseguir"/>

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:textSize="16sp"/>

        <Button
            android:id="@+id/btnLimpar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:text="Limpar"/>
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
