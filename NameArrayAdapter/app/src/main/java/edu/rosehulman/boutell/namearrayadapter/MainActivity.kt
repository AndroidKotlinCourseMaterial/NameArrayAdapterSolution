package edu.rosehulman.boutell.namearrayadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rosterAndRandomNames: Array<String>
    private val namesToDisplay = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initializeNames()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesToDisplay)
        list_view.adapter = adapter

        fab.setOnClickListener { view ->
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
            "Mohammad",
            "John",
            "Xiangbei (Claudia)",
            "Yifei (Fay)",
            "Alyssa",
            "Connor",
            "Yang (Winston)",
            "Jacob",
            "Shixian (Sonia)",
            "Yuhan (Frost)",
            "Sebastian",
            "Jordan",
            "Eugene",
            "Ruojie (Valerie)",
            "Matthew",
            "Yiyu (Maggie)",
            "Arjun",
            "Aaron",
            "Eric",
            "Shinmon",
            "Jingrui (Jerry)",
            "Mengyue",
            "Xiangnan (Tiger)",
            "Keith",
            "Yifan (Augustine)",
            "Anand",
            "Alexander",
            "Samuel",
            "Chuhan (Alan)",
            "Yihui (Solomon)",
            "Bryan",
            "Jordan",
            "Bailey",
            "Jianan",
            "Andrew",
            "XiaoLi (Tony)",
            "Xiao",
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
