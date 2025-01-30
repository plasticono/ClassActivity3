package edu.temple.classactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLogin()
    }

    private var accounts = ArrayList<Account>()


    private fun toSignup(){
        setContentView(R.layout.sign_up)
        findViewById<Button>(R.id.signup_back).setOnClickListener({setupLogin()})
        //get data from text inputs and attempt to sign up

        findViewById<Button>(R.id.signup_new).setOnClickListener({
            var email_field : String = findViewById<TextView>(R.id.s_email).text.toString()
            var name_field : String = findViewById<TextView>(R.id.s_name).text.toString()
            var age_field : Int = findViewById<TextView>(R.id.s_age).text.toString().toInt()
            var password1 : String = findViewById<TextView>(R.id.s_password1).text.toString()
            var password2 : String = findViewById<TextView>(R.id.s_password2).text.toString()

            if(!password1.equals(password2,false)) {
               //passwords do not match
                return@setOnClickListener
            }

            var account = Account(name_field, email_field, password1, age_field)
            accounts.add(account)
            setupLogin()

        })


    }

    private fun setupLogin(){
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.signup_button).setOnClickListener({
            toSignup()
        });
        //on login button clicked: attempt to log in
        findViewById<Button>(R.id.login_button).setOnClickListener({
            var email : String = findViewById<TextView>(R.id.email_input).text.toString()
            var password : String = findViewById<TextView>(R.id.password_input).text.toString();

            for(account in accounts){
                //should probabbly make this its own function and end the loop
                if(account.email.equals(email, true) && account.password.equals(password, false)){
                    findViewById<TextView>(R.id.status).text = "Logged in: ${account.name}"
                }
                return@setOnClickListener
            }
        })
    }
}