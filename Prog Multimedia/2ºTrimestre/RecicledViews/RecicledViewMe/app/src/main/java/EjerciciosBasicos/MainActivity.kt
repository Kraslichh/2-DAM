package EjerciciosBasicos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recicledviewme.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personList = generatePersonList()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val personAdapter = PersonAdapter(personList)
        recyclerView.adapter = personAdapter
    }

    private fun generatePersonList(): List<Person> {
        return listOf(
            Person("Alberto","Ruiz"),
            Person("Juan","Perez"),
            Person("Eva","Garcia"),
            Person("Alberto",""),
            Person("Laura",""),
            Person("Cristina",""),
            Person("Isabel",""),
            Person("Pedro", "Moreno"),
            Person("Jose","Android"),
            Person("Manuel", "Oracle"),
            Person("Diana","Hibernate"),


            )
    }
}
