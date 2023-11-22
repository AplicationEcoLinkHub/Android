package esprit.tn.ecolinkhubapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initiatives)

        val marcheBioImageView: ImageView = findViewById(R.id.legume)
        marcheBioImageView.setOnClickListener {
            val intent = Intent(this, Marche_initActivity::class.java)
            startActivity(intent)
        }

        val dechet: ImageView = findViewById(R.id.poubelle)
        dechet.setOnClickListener {
            val intent = Intent(this, Dechet_initActivity::class.java)
            startActivity(intent)
        }
        val consommation: ImageView = findViewById(R.id.consommation)
        consommation.setOnClickListener {
            val intent = Intent(this, Consommation_initActivity::class.java)
            startActivity(intent)
        }
        val energie: ImageView = findViewById(R.id.energie)
        energie.setOnClickListener {
            val intent = Intent(this, Energie_initActivity::class.java)
            startActivity(intent)
        }
        val eau: ImageView = findViewById(R.id.eau)
        eau.setOnClickListener {
            val intent = Intent(this, Eau_initActivity::class.java)
            startActivity(intent)
        }
        val covoiturage: ImageView = findViewById(R.id.covoiturage)
        covoiturage.setOnClickListener {
            val intent = Intent(this, Covoiturage_initActivity::class.java)
            startActivity(intent)
        }
        val menu: ImageView = findViewById(R.id.menu)
        menu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }}


