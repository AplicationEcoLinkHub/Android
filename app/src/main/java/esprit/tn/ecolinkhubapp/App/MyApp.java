package esprit.tn.ecolinkhubapp.App;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import esprit.tn.ecolinkhubapp.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    private final String BASE_URL = "http://10.0.2.2:8000/";
    private ApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    @NotNull
    public ApiService getApiService() {
        if (apiService == null) {
            throw new IllegalStateException("ApiService n'a pas été initialisé. Assurez-vous d'appeler onCreate() dans votre Application.");
        }
        return apiService;
    }
}
