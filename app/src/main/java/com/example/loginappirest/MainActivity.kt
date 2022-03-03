package com.example.loginappirest

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.loginappirest.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.swType.setOnCheckedChangeListener{ button ,checked ->
            button.text = if(checked) getString(R.string.main_type_login)
            else getString(R.string.main_type_register)
            mBinding.swType.text = button.text
        }

        mBinding.btnLogin.setOnClickListener{
            login()
        }
    }

    private fun login() {
        val typemethod = if(mBinding.swType.isChecked) Constants.API_LOGIN else Constants.API_REGISTER
        val url = Constants.BASE_URL +  Constants.API_Path + typemethod

        //Creamos el json PETICION
        val jsonParams = JSONObject()
        val params2 : String 

        val jsonObject = object : JsonObjectRequest(Request.Method.POST, url , jsonParams, {
            updateUI(":)")
        },{

            it.printStackTrace()
            if(it.networkResponse.statusCode== 400){
                updateUI(getString(R.string.main_error_server))
            }
        }){
            override fun getHeaders(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["Content-Type"] = "application/json"

                return super.getHeaders()
            }
        }

        LoginApplication.reqResApi.addToRequestQueue(jsonObject)
    }

    private fun updateUI(result: String) {
        mBinding.tvResult.visibility = View.VISIBLE
        mBinding.tvResult.text= result
    }
}