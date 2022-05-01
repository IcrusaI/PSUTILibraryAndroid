package com.crusa.psutilibrary.retrofit;

import com.crusa.psutilibrary.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LibraryPSUTIApiService {
    @GET("books")
    Call<List<Book>> getBooks();
}
