/// A lista de itens foi imutável, o que gerava um erro ao tentar adicionar novos itens.
Não havia controle para atualizar a RecyclerView corretamente após adicionar novos itens. ////

MainActivity.kt
package com.example.myrecyclerviewapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val itemList = mutableListOf<String>("Item 1", "Item 2", "Item 3", "Item 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Corrigido: Inicializando RecyclerView e Adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        // Corrigido: Ao adicionar novo item, lista é atualizada corretamente
        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            adapter.addItem("New Item")
        }
    }
}              /// Erro 1: A lista itemList usada no Adapter estava imutável. Isso impedia a adição de novos itens. Corrigimos isso criando uma MutableList.
// Erro 2: RecyclerView não estava sendo atualizado corretamente ao adicionar um item, então modificamos a lista para mutável e chamamos notifyItemInserted() no Adapter. ///

 
ItemAdapter.kt

// Não era possível modificar a lista original, pois estava sendo passada como uma lista imutável. Havia problemas na função bind() com o tipo de dado e o uso do EditText. O ItemAdapter estava trabalhando com uma lista que não era atualizada de forma adequada. //


package com.example.myrecyclerviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerviewapp.databinding.ItemLayoutBinding

class ItemAdapter(private val itemList: MutableList<String>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    // Corrigido: Mudando a lista corretamente e atualizando a RecyclerView
    fun addItem(item: String) {
        itemList.add(item)  // Adicionando item à lista
        notifyItemInserted(itemList.size - 1)
    }

    class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        // Corrigido: Ligando corretamente o valor ao EditText
        fun bind(item: String) {
            binding.itemInput.setText(item)
        }
    }
} // Erro 1: A lista itemList precisa ser mutável para que possamos adicionar itens nela dinamicamente. Agora passamos a lista como MutableList<String>. Erro 2: A função addItem() agora modifica diretamente a lista e chama notifyItemInserted() para informar a RecyclerView que um novo item foi adicionado.Erro 3: Na função bind(), o método setText() foi corrigido para atualizar o EditText corretamente. //


activity_main.xml 
// As restrições de layout não estavam aplicadas corretamente, o que poderia gerar problemas de renderização. //

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Corrigido: Ajuste das restrições -->
    <Button
        android:id="@+id/addButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Add Item"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@+id/addButton"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout> // Erro 1: O botão addButton não estava centrado horizontalmente. Adicionei a restrição app:layout_constraintEnd_toEndOf="parent" para corrigir isso.Erro 2: Ajustei as restrições do RecyclerView para garantir que ele preencha a tela corretamente, evitando problemas visuais. //


 item_layout.xml
//Problemas de restrição com o layout e ajuste de margens.//

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <!-- Corrigido: Ajustes de restrições e margens -->
    <EditText
        android:id="@+id/itemInput"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter item"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp" />

</androidx.constraintlayout.widget.ConstraintLayout> //Erro 1: Ajustei as margens e as restrições do EditText para garantir que o componente esteja corretamente posicionado e tenha uma boa aparência visual.//


