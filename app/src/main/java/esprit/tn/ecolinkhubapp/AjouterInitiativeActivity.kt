package esprit.tn.ecolinkhubapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import esprit.tn.ecolinkhubapp.App.MyApp
import esprit.tn.ecolinkhubapp.models.InitiativeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AjouterInitiativeActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ajout_initiative)

        // Vérifier la classe de l'application
        val myApp = application as? MyApp
            ?: throw RuntimeException("L'application n'est pas une instance de MyApp")

        // Initialisation de Retrofit dans l'activité
        apiService = myApp.apiService

        // Gérer le clic sur le bouton d'ajout
        val ajouterButton: Button = findViewById(R.id.ajouter)
        ajouterButton.setOnClickListener {
            ajouterInitiative()
        }
        val ajouterImageView3 = findViewById<ImageView>(R.id.accueil)

        ajouterImageView3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)


            startActivity(intent)
        }

        val menu: ImageView = findViewById(R.id.menu)
        menu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun ajouterInitiative() {
        // Récupérer les données depuis les champs de l'interface utilisateur
        val titre = findViewById<EditText>(R.id.editTextText).text.toString()
        val description = findViewById<EditText>(R.id.editTextText3).text.toString()
        val heure = findViewById<EditText>(R.id.editTextText6).text.toString()
        val localisation = findViewById<EditText>(R.id.editTextText4).text.toString()
        val numero = findViewById<EditText>(R.id.editTextNumber).text.toString()
        val photo = findViewById<EditText>(R.id.editTextText5).text.toString()

// Créer un objet InitiativeModel avec les données
        val nouvelleInitiative = InitiativeModel(titre, description, heure, localisation, numero, photo)


        // Afficher les données à envoyer dans les logs
        Log.d("Ajout", "Données à envoyer : $nouvelleInitiative")

        // Appeler l'API pour ajouter l'initiative
        val call = apiService.ajouterInitiative(nouvelleInitiative)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // L'ajout a réussi
                    Log.d("Ajout", "Ajout réussi")

                    // Rediriger vers la page "Marche Bio" avec les informations ajoutées
                    val intent = Intent(this@AjouterInitiativeActivity, MarcheBioActivity::class.java).apply {
                        putExtra("nomEntreprise", titre)
                        putExtra("descriptionEntreprise", description)
                        putExtra("heureOuverture", heure) // Utilisez heureText pour conserver le format original
                        putExtra("localisation", localisation)
                        putExtra("numero", numero)
                        putExtra("imageView2", photo)
                    }
                    startActivity(intent)
                    finish()
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("Ajout", "Veillez remplir les champs: ${response.code()} - $errorBody")
                    Toast.makeText(
                        this@AjouterInitiativeActivity,
                        "Veillez remplir les champs: $errorBody",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Gérer les erreurs de réseau
                Log.e("Ajout", "Erreur de réseau: ${t.message}")
                Toast.makeText(
                    this@AjouterInitiativeActivity,
                    "Erreur de réseau",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }}