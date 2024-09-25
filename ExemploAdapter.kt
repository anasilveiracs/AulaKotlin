package br.unipar.exemploadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class TarefaAdapter(
    private val context: Context,
    private val listaTarefas: MutableList<Tarefa>) : ArrayAdapter<Tarefa>(context, 0, listaTarefas) { override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        //pega a tarefa atual no meu "for
        val tarefa = listaTarefas.get(position)
        //Aponta qual layout sera utilizado
        val view = LayoutInflater.from(context).inflate(R.layout.item_tarefa, parent, false)

        // pega os campos do layout escolhido
        val descricao = view.findViewById<TextView>(R.id.txtDescricao)
        val data = view.findViewById<TextView>(R.id.txtData)
        val concluido = view.findViewById<CheckBox>(R.id.cbTarefaConcluida)

        //joga o valor da tarefa para o campo da tela
        descricao.setText(tarefa.descricao)
        data.setText(tarefa.data)
        concluido.isChecked = tarefa.concluida

      concluido.setOnCheckedChangeListener { _, isChecked ->
    tarefa.concluida = isChecked
}
        return view

    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="729dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Lista de Tarefas"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/edTarefa"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Informe uma tarefa"
            android:inputType="text" />

        <Button
            android:id="@+id/btnCadastrar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="50sp"
            android:layout_marginTop="10sp"
            android:layout_marginRight="50sp"
            android:layout_marginBottom="10sp"
            android:text="Cadastrar" />

        <ListView
            android:id="@+id/listViewTarefas"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
