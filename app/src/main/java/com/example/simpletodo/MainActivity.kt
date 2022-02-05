package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    var listOfTasks = mutableListOf<String>()
    lateinit var adapter: TaskItemadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val onLongClickListener = object : TaskItemadapter.OnLongClickListener{
    override fun onItemLongClicked(position: Int) {
        listOfTasks.removeAt(position)
adapter.notifyDataSetChanged()
        saveitems()
    }


}
     //   findViewById<Button>(R.id.button).setOnClickListener{

//Log.i("Jim","user click on button")
       loadItems()
       val recyclerView= findViewById<RecyclerView>(R.id.recyclerview)
 adapter =TaskItemadapter(listOfTasks,onLongClickListener)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this)


findViewById<Button>(R.id.button).setOnClickListener{
val userInputtedTask =findViewById<EditText>(R.id.editTextTextPersonName).text.toString()

    listOfTasks.add(userInputtedTask)
adapter.notifyItemInserted(listOfTasks.size-1)
findViewById<EditText>(R.id.editTextTextPersonName).setText("")
    saveitems()
}

        }
fun getDataFile(): File{


    return File(filesDir,"data.txt")

}
fun loadItems(){

    listOfTasks= FileUtils.readLines(getDataFile(), Charset.defaultCharset())



}
    fun saveitems() {
        try {
            FileUtils.writeLines(getDataFile(), listOfTasks)
        } catch (ioException: IOException) {
ioException.printStackTrace()
        }
    }}
//}