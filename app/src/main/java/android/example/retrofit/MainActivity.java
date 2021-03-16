package android.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SwipeRefreshLayout swipe;
    CurrenciesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        swipe = findViewById(R.id.pullToRefresh);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                parseData();
                swipe.setRefreshing(false);
            }
        });
        parseData();
    }

    public void setAdapter(List<Currencies> list){
        adapter = new CurrenciesListAdapter(this, R.layout.adapter_view_list, new ArrayList<Currencies>(list));
        listView.setAdapter(adapter);

    }

    private void parseData(){
        Thread parseThread =  new Thread(new Runnable() {
            @Override
            public void run() {
                NetworkService.getInstance()
                        .getJSONApi()
                        .getAllCurrencies()
                        .enqueue(new Callback<List<Currencies>>() {
                            @Override
                            public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {
                                List<Currencies> list = response.body();
                                setAdapter(list);
                            }

                            @Override
                            public void onFailure(Call<List<Currencies>> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
            }
        });
        parseThread.start();
    }
}