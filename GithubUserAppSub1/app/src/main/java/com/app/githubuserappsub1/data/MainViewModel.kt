package com.app.githubuserappsub1.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainViewModel : ViewModel() {

    val listDataUser = MutableLiveData<ArrayList<GithubUser>>()
    val listItemDataUser = ArrayList<GithubUser>()

    fun setData(context: Context) {

        var inputStream: InputStream? = null
        var jString: String? = null

        try {
            inputStream = context.assets.open("githubuser.json")
            jString = inputStream.bufferedReader().use { it.readText() }
        } catch (e: IOException) {

        }
        val responseObject = JSONObject(jString.toString())
        val list = responseObject.getJSONArray("users")

        for (i in 0 until list.length()) {
            val dataItem = list.getJSONObject(i)
            val githubUser = GithubUser(
                dataItem.getString("username"),
                dataItem.getString("name"),
                dataItem.getString("company"),
                dataItem.getString("location"),
                dataItem.getString("repository"),
                dataItem.getString("avatar"),
                dataItem.getInt("follower"),
                dataItem.getInt("following")
            )
            listItemDataUser.add(githubUser)
        }
        listDataUser.postValue(listItemDataUser)
    }

    fun getData(): MutableLiveData<ArrayList<GithubUser>> {
        return listDataUser
    }
}