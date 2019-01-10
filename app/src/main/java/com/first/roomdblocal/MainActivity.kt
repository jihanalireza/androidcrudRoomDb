package com.first.roomdblocal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.first.roomdblocal.database.AppDatabase
import com.first.roomdblocal.database.User
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.coroutines.experimental.bg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reference = this.asReference()
        async(UI) {
          val data = bg {
              AppDatabase.getDatabase(this@MainActivity).userDao().getAll()
          }
            showData(data.await())
        }
    }


    fun insertData(){

        var fname = "jihan"
        var lname = "reza"

        var user = User()
        user.firstName = fname
        user.lastName = lname
        AppDatabase.getDatabase(this@MainActivity).userDao().insertAll(user)
    }


    fun showData(data: List<User>){
        alert {
            title = "Alert"
            message = data.toString()
            yesButton {  }
            noButton {  }
        }.show()
    }

}

