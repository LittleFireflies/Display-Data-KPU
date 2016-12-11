package id.sch.smktelkom_mlg.learn.datakpu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.datakpu.adapter.CandidacyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCandidacy;
    private ArrayList<JSONResponse> candidacyList = new ArrayList<>();
    private CandidacyAdapter candidacyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCandidacy = (RecyclerView) findViewById(R.id.rvCandidacy);
        rvCandidacy.setHasFixedSize(true);
        rvCandidacy.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.kpu.go.id/open/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        for (int id = 1; id <= 5; id++) {
            Call<JSONResponse> call = request.getJSON(String.valueOf(id));
            call.enqueue(new Callback<JSONResponse>() {
                @Override
                public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                    JSONResponse jsonResponse = response.body();
                    if (jsonResponse.getData() != null) {
                        candidacyList.add(response.body());

                        candidacyAdapter = new CandidacyAdapter(candidacyList);
                        rvCandidacy.setAdapter(candidacyAdapter);
                    } else {
                        Log.d("Storage", "Storage is null");
                    }
                }

                @Override
                public void onFailure(Call<JSONResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                }
            });
        }
    }
}
