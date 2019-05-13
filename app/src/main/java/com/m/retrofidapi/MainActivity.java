package com.m.retrofidapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EmpAPI empAPI;
    Retrofit retrofit;
    private  static final String BASE_URL="http://dummy.restapiexample.com/api/v1/";
  TextView tviewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tviewData=findViewById(R.id.tvData);
        LoadData();
    }

    private void createInstance(){

     retrofit=new Retrofit.Builder().
             baseUrl(BASE_URL).
             addConverterFactory(GsonConverterFactory.create()).build();
        empAPI=retrofit.create(EmpAPI.class);

    }

    private void LoadData(){
        createInstance();
        Call <List<Employee_Model>> empcall=empAPI.getEmployee();
        empcall.enqueue(new Callback<List<Employee_Model>>() {
            @Override
            public void onResponse(Call<List<Employee_Model>> call, Response<List<Employee_Model>> response) {
                 String data=response.body().toString();
                 tviewData.setText(data);

            }

            @Override
            public void onFailure(Call<List<Employee_Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
