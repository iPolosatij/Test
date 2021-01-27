package space.digitallab.testappforarview

import Json4Kotlin_Base
import Top
import android.app.AlertDialog
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import space.digitallab.kotlinretrofitpicassospotsdialog.Adapter.GameListAdapter
import space.digitallab.testappforarview.common.Common
import space.digitallab.testappforarview.database.DB
import space.digitallab.testappforarview.database.DBHelper
import space.digitallab.testappforarview.database.DBinterface
import space.digitallab.testappforarview.network.ApiInterface
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mService: ApiInterface
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: GameListAdapter
    lateinit var dialog: AlertDialog
    lateinit var db: ArrayList<DB>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mService = Common.apiInterface
        recyclerList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        val accept = "application/vnd.twitchtv.v5+json"
        val device_id = "sd4grh0omdj9a31exnpikhrmsu3v46"

        if (isOnline()) {
            val dBinterface = DBinterface(DBHelper(this))
            dBinterface.dbClear()
            getGameList(accept, device_id)}
        else {
            val dBinterface = DBinterface(DBHelper(this))
            dBinterface.dataRead(db as ArrayList<DB>)
        }
    }

    private fun getGameList(first: String?, second: String?) {
        dialog.show()
        mService.getList(first, second).enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<Json4Kotlin_Base>,
                response: Response<Json4Kotlin_Base>
            ) {

                GameListAdapter(baseContext, response.body()!!.top as List<Top>).also {
                    adapter = it
                    addDB(response.body()!!.top)
                }
                adapter.notifyDataSetChanged()
                recyclerList.adapter = adapter

                dialog.dismiss()
            }
        })
    }

    fun isOnline(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    fun addDB(list: List<Top>){
        var baseList: ArrayList<DB>? = null
        for(top: Top in list) {
            var dbitem = DB(0, top.game.name, top.channels.toString(), top.viewers.toString())
            baseList?.add(dbitem)
        }
        val dBinterface = DBinterface(DBHelper(this))
        dBinterface.dataRead(baseList)
    }

    fun feedBack(view: View) {

        val intent = Intent(this, FeedBack::class.java)
        startActivity(intent)
    }
}