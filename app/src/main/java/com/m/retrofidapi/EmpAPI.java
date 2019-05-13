package com.m.retrofidapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmpAPI {
    @GET("employees")
    Call<List<Employee_Model>> getEmployee();

    @GET("employee/{id}")
    Call <Employee_Model> getEmployeeById(@Path("id")int id);
}
