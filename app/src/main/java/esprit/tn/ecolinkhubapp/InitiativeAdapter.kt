
package esprit.tn.ecolinkhubapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import esprit.tn.ecolinkhubapp.models.InitiativeModel

// Créez une nouvelle classe InitiativeAdapter
class InitiativeAdapter(private val initiatives: MutableList<InitiativeModel>) :
    RecyclerView.Adapter<InitiativeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomEntreprise: TextView = itemView.findViewById(R.id.nomEntreprise)
        val descriptionEntreprise: TextView = itemView.findViewById(R.id.descriptionEntreprise)
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_initiative, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val initiative = initiatives[position]

        // Associez les données de l'initiative aux vues dans la carte
        holder.nomEntreprise.text = initiative.titre
        holder.descriptionEntreprise.text = initiative.description

        // Chargez l'image à partir de la ressource, de l'URL ou du chemin du fichier
        // Pour cet exemple, je suppose que vous avez une ressource drawable avec le nom "cercle_jaune"
        holder.imageView.setImageResource(R.drawable.cercle_jaune)

        // Ajoutez des écouteurs de clic si nécessaire
        holder.itemView.setOnClickListener {
            // Gérez le clic sur l'initiative, par exemple, ouvrez une nouvelle activité avec plus de détails
        }
    }

    override fun getItemCount(): Int {
        return initiatives.size
    }

    // Fonction pour mettre à jour la liste d'initiatives
    fun updateInitiatives(newInitiatives: List<InitiativeModel>) {
        initiatives.clear()
        initiatives.addAll(newInitiatives)
        notifyDataSetChanged()
    }
}
