package ir.adicom.app.androidbasicsinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.androidbasicsinkotlin.adapter.ItemAdapter
import ir.adicom.app.androidbasicsinkotlin.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSource = DataSource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ItemAdapter(this, dataSource)

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }
}