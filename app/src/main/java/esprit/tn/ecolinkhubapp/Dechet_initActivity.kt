package esprit.tn.ecolinkhubapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Dechet_initActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dechet_init)

        val ajouterImageView = findViewById<ImageView>(R.id.ajouter)

        ajouterImageView.setOnClickListener {
            val intent = Intent(this, AjouterInitiativeActivity::class.java)


            startActivity(intent)
        }
        val menu: ImageView = findViewById(R.id.menu)
        menu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }}