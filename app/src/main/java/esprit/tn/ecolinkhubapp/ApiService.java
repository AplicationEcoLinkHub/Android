package esprit.tn.ecolinkhubapp;

import java.util.List;

import esprit.tn.ecolinkhubapp.models.InitiativeModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/initiatives")
    Call<Void> ajouterInitiative(@Body InitiativeModel initiative);

    @GET("api/initiatives")
    Call<List<InitiativeModel>> getInitiatives();

}
