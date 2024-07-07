package com.lucas.valli.geradordesenha

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lucas.valli.geradordesenha.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val alfabeto = arrayOf("A","B","C","D","E","F","G","H","I",'J',"K",
        "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnGerarSenha.setOnClickListener {
            val letra1 = alfabeto.random()
            val letra2 = alfabeto.random()
            val numero = Random.nextInt(1000..9999)

            binding.txtSenha.text = "$letra1$letra2-$numero"



        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}