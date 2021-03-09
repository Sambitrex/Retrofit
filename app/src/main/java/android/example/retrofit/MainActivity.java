package android.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                NetworkService.getInstance()
                        .getJSONApi()
                        .getAllCurrencies()
                        .enqueue(new Callback<List<Currencies>>() {
                            @Override
                            public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {
                                List<Currencies> list = response.body();

                                Log.d("MyLog", list.get(0).getCur_Name());
                                Log.d("MyLog", String.valueOf(list.get(0).getCur_Scale()));
                                Log.d("MyLog", String.valueOf(list.get(0).getCur_OfficialRate()));
                            }

                            @Override
                            public void onFailure(Call<List<Currencies>> call, Throwable t) {

                            }
                        });
    }
}