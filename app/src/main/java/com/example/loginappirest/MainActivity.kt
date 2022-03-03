package com.example.loginappirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loginappirest.databinding.ActivityMainBinding

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
        updateUI(":)")
    }

    private fun updateUI(result: String) {
        mBinding.tvResult.visibility = View.VISIBLE
        mBinding.tvResult.text= result
    }
}