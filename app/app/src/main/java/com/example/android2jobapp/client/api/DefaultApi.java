package com.example.android2jobapp.client.api;

import com.example.android2jobapp.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.android2jobapp.client.model.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  
  /**
   * Creates a new application.
   * Creates a new application.
   * @param body 
   * @return Call<Void>
   */
  
  @POST("application")
  Call<Void> postApplication(
    @Body Application body
  );

  
  /**
   * Updates the application of the ID.
   * Updates the application of the ID.
   * @param id 
   * @param body 
   * @return Call<Void>
   */
  
  @PUT("application/{id}")
  Call<Void> putApplicationId(
    @Path("id") String id, @Body Application body
  );

  
  /**
   * Deletes the application of the ID.
   * Deletes the application of the ID.
   * @param id 
   * @return Call<Void>
   */
  
  @DELETE("application/{id}")
  Call<Void> deleteApplicationId(
    @Path("id") String id
  );

  
}
