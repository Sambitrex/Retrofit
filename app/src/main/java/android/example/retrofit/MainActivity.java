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

        new Thread(new Runnable() {
            @Override
            public void run() {
                NetworkService.getInstance()
                        .getJSONApi()
                        .getAllCurrencies()
                        .enqueue(new Callback<List<Currencies>>() {
                            @Override
                            public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {
                                List<Currencies> list = response.body();

                                for(Currencies cur : list) {
                                    Log.d("MyLog", cur.getCur_Name());
                                    Log.d("MyLog", String.valueOf(cur.getCur_Scale()));
                                    Log.d("MyLog", String.valueOf(cur.getCur_OfficialRate()));
                                }
                            }

                            @Override
                            public void onFailure(Call<List<Currencies>> call, Throwable t) {

                            }
                        });

            }
        }).start();
    }
}