package com.example.ev
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
/*
        textField.setOnClickListener(this); // calling onClick() method

        textField.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                Log.d("focus", "Change0")

            } else {
                Toast.makeText(applicationContext, "Lost the focus", Toast.LENGTH_LONG).show()
            }
        }
        btn_login.setOnClickListener {
            isValidMobile(textField.toString())
        }
        textField.setOnFocusChangeListener { v, hasFocus ->
            Log.d("dfdfd","dafdaf")

            if (!hasFocus) {
                Log.d("dfdfd","dafdaf")
                this.hideKeyboard(v)
                v.clearFocus()
            }
        }*/

    }
}

   /* override fun onClick(v: View?) {

        Log.d("dfdfd","lcheck"+v?.id.toString()+"dsf"+R.id.textField)
        if (v?.id == R.id.textField) {

            Log.d("dfdfd","onclick workig daw")


        }
        else{
            Log.d("dfdfd","outside onclick workig daw")

        }
    }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

@BindingAdapter("onClickWithFocusChange")
fun View.setOnClickWithFocusChangeListener(clickListener: View.OnClickListener?) {
    clickListener?.also {
        setOnClickListener(OnClickWithFocusChangeListener(it))
    } ?: setOnClickListener(null)
}

class OnClickWithFocusChangeListener(
    private val clickListener: View.OnClickListener
) : View.OnClickListener {

    override fun onClick(v: View?) {
        v?.requestFocusFromTouch()
        clickListener.onClick(v)
        v?.clearFocus()
    }
}

private fun isValidMobile(phone: String): Boolean {
    return Patterns.PHONE.matcher(phone).matches()*/





