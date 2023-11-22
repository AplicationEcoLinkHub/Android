package esprit.tn.ecolinkhubapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MarcheBioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.marchebio)

        // Récupérer les données depuis l'intent
        val titre = intent.getStringExtra("nomEntreprise")
        val description = intent.getStringExtra("descriptionEntreprise")
        val heure = intent.getStringExtra("heureOuverture")
        val photo = intent.getStringExtra("imageView2")

        // Afficher les données sur la page
        val textViewTitre = findViewById<TextView>(R.id.nomEntreprise)
        val textViewDescription = findViewById<TextView>(R.id.descriptionEntreprise)
        val textViewHeure = findViewById<TextView>(R.id.heureOuverture)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)

        textViewTitre.text = titre
        textViewDescription.text = description
        textViewHeure.text = heure
        // Chargez l'image à partir de la ressource, de l'URL, ou du chemin du fichier, selon vos besoins
        // Pour cet exemple, je suppose que vous avez une ressource drawable avec le nom "your_default_image"
        imageView2.setImageResource(R.drawable.cercle_jaune)

        // Vous pouvez également configurer l'écouteur de clic programmatically (en code)
        val likeImageView = findViewById<ImageView>(R.id.like)
        likeImageView.setOnClickListener {
            changerCouleurImage(it)
        }

        val ajouterImageView = findViewById<ImageView>(R.id.ajouter)

        ajouterImageView.setOnClickListener {
            val intent = Intent(this, AjouterInitiativeActivity::class.java)


            startActivity(intent)
        }
        // Gérer le clic sur le bouton "Appeler"
        val appelerButton: Button = findViewById(R.id.appeler)
        appelerButton.setOnClickListener {
            appelerNumeroPredefini()
        }
        val ajouterImageView2 = findViewById<ImageView>(R.id.edit)


        ajouterImageView2.setOnClickListener {
            val intent = Intent(this, ModifierInitiativeActivity::class.java)


            startActivity(intent)
        }
        val ajouterImageView3 = findViewById<ImageView>(R.id.accueil)

        ajouterImageView3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)


            startActivity(intent)
        }
        // Gérer le clic sur le bouton "Partager"
        val partagerButton: Button = findViewById(R.id.partagerButton)
        partagerButton.setOnClickListener {
            partagerContenu()
        }
        val ajouterImageView4 = findViewById<ImageView>(R.id.delete)


        ajouterImageView4.setOnClickListener {
            val intent = Intent(this, deleteActivity::class.java)


            startActivity(intent)
        }

        val menu: ImageView = findViewById(R.id.menu)
        menu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        val buttonItineraire: Button = findViewById(R.id.button_itineraire)
        buttonItineraire.setOnClickListener {

            val latitude = 36.8858
            val longitude = 10.3286

            // Créer l'URI pour l'intention
            val geoUri = "geo:$latitude,$longitude?q=$latitude,$longitude"

            // Créer l'intention avec l'URI
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))

            // Vérifier si l'application Google Maps est installée
            mapIntent.setPackage("com.google.android.apps.maps")

            // Démarrer l'activité avec l'intention
            startActivity(mapIntent)
        }
    }
    private fun partagerContenu() {
        // Récupérer les données depuis l'intent
        val titre = intent.getStringExtra("nomEntreprise")
        val description = intent.getStringExtra("descriptionEntreprise")
        val heure = intent.getStringExtra("heureOuverture")

        // Créer le texte que vous souhaitez partager
        val textePartage = "Découvrez $titre : $description, Ouvert à $heure."

        // Créer une intention pour partager le texte
        val partagerIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, textePartage)
        }

        // Démarrer l'activité avec l'intention
        startActivity(Intent.createChooser(partagerIntent, "Partager avec"))
    }
    private fun appelerNumeroPredefini() {
        // Remplacez ce numéro par le numéro que vous souhaitez appeler
        val numeroPredefini = "50929839"

        // Créer l'URI pour l'intention d'appel
        val telUri = Uri.parse("tel:$numeroPredefini")

        // Créer l'intention avec l'URI
        val appelIntent = Intent(Intent.ACTION_DIAL, telUri)

        // Démarrer l'activité avec l'intention
        startActivity(appelIntent)
    }

    // Fonction appelée lors du clic sur l'image
    fun changerCouleurImage(view: View) {
        // Changer la couleur de l'icône en rouge
        val likeImageView = findViewById<ImageView>(R.id.like)
        likeImageView.setColorFilter(Color.RED)
    }






}

