package android.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("/api/exrates/rates?periodicity=0")
    public Call<List<Currencies>> getAllCurrencies();

}
