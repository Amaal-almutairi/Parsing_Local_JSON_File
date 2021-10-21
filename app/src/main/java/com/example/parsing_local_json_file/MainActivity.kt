package com.example.parsing_local_json_file

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.IOException





class MainActivity : AppCompatActivity() {
    //Declaring the UI elements.
    lateinit var Img: ArrayList<Image>
    lateinit var Adap: myAdapter
    lateinit var RvImg: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialising the UI elements.
        Img = arrayListOf()
        RvImg = findViewById(R.id.rv)
        Adap = myAdapter(this, Img)
        RvImg.adapter = Adap
        RvImg.layoutManager = LinearLayoutManager(this)
        // taking data after reading the file and store it inside jsonF
        val jsonF = getData(this@MainActivity, "data.json")
        // showing images
        showImage(jsonF)


    }


    fun getData(context: Context, fileName: String): String {
        var jsonstr = ""

        try {
            // reading the json file and store the data inside jsonstr

            jsonstr = context.assets.open(fileName).bufferedReader().use { it.readText() }
            // using try and catch to prevent app from crashing and to make sure there is input and output
        } catch (ioException: IOException) {
            // printing the error
            ioException.printStackTrace()
        }
        return jsonstr


}


    fun showImage(data:String){
    // getting data (Images)  directly from data.json and store it in jsonObject

        val jsnobj = JSONArray(data)

        for(i in 0 until jsnobj.length()){
            // getting every url and store it inside url variable
            val url = jsnobj.getJSONObject(i).getString("url")
            // adding url in array
        Img.add(Image(url))

    }
        // update the recycler view
        Adap.notifyDataSetChanged()
}}