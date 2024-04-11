package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
            }
        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icone", contact.icon)
            startActivity(intent)

        }
    }
}

private val contacts = listOf(
    Contact(
        name = "Isadora",
        phone = "(55)48 991248733",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Douglas",
        phone = "(55)48 991455514",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Ana",
        phone = "(55)48 991242859",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Joana",
        phone = "(55)48 999587800",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "Carla",
        phone = "(55)48 991244728",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Marcia",
        phone = "(55)48 998458712",
        icon = R.drawable.sample6
    ),
    Contact(
        name = "Yuki",
        phone = "(55)47 984250964",
        icon = R.drawable.sample7
    ),
    Contact(
        name = "Gustavo",
        phone = "(55)41 984660087",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "João",
        phone = "(55)54 996124822",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Israel",
        phone = "(55)49 982641001",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Cristina",
        phone = "(55)11 996323223",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Marcelo",
        phone = "(55)13 999152174",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Vanessa",
        phone = "(55)67 981156708",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Justin",
        phone = "(55)54 991009813",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Rebecca",
        phone = "(55)48 991472200",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Brenda",
        phone = "(55)47 984125877",
        icon = R.drawable.sample16
    )
)