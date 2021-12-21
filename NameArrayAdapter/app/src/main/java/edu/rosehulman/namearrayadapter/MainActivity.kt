package edu.rosehulman.namearrayadapter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import edu.rosehulman.namearrayadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var rosterAndRandomNames: Array<String>
    private val namesToDisplay = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initializeNames()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesToDisplay)
        binding.contentMain.listView.adapter = adapter
        binding.fab.setOnClickListener {
            addRandomName()
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initializeNames() {
        rosterAndRandomNames = arrayOf(
            "Evan",
            "Stephen",
            "Charlie",
            "Natalie",
            "Michael",
            "Jasmine",
            "Xingheng",
            "Elvis",
            "Nick",
            "Adithya",
            "Jasmine",
            "Nicholas",
            "Blake",
            "Elle",
            "Rachel",
            "Darren",
            "Deng",
            "Vik",
            "Max",
            "Vuk",
            "Brandon",
            "Edward",
            "Lyra",
            "Jack",
            "Hannah", // plus some other very-common names.
            "Emily",
            "Sarah",
            "Madison",
            "Brianna",
            "Kaylee",
            "Kaitlyn",
            "Hailey",
            "Alexis",
            "Elizabeth",
            "Michael",
            "Jacob",
            "Matthew",
            "Nicholas",
            "Christopher",
            "Joseph",
            "Zachary",
            "Joshua",
            "Andrew",
            "William"
        )
        for (k in 0 until 5) {
            addRandomName()
        }
    }

    private fun addRandomName() {
        // Random array element from https://stackoverflow.com/questions/47850156/get-a-random-item-from-list-using-kotlin-streams
        namesToDisplay.add(0, rosterAndRandomNames.random())
    }
}