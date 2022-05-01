package com.crusa.psutilibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.crusa.psutilibrary.adapter.BooksAdapter;
import com.crusa.psutilibrary.model.Author;
import com.crusa.psutilibrary.model.Book;
import com.crusa.psutilibrary.model.Faculty;
import com.crusa.psutilibrary.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BooksActivity extends Activity {

    private final static String TAG = "BooksActivity";

    RecyclerView rvBooks;
    private List<Book> books;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_books);

        rvBooks = findViewById(R.id.booksList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(llm);
        rvBooks.setHasFixedSize(false);

        Spinner spinner = findViewById(R.id.faculty_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.faculties_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {

        books = new ArrayList<>();

        Author author = new Author();
        author.setId((long) 1);
        author.setName("Якуп Денис Олегович");

        Book book = new Book();
        book.setTitle("Когда");
        book.setSemester(1);
        book.setFaculty(Faculty.FIST);
        book.setDownloadLink("asd");
        book.setId((long) 1);
        book.setAuthor(author);

        books.add(book);

        Book book1 = new Book();
        book1.setTitle("Где");
        book1.setSemester(1);
        book1.setFaculty(Faculty.FBTO);
        book1.setDownloadLink("asd");
        book1.setId((long) 2);
        book1.setAuthor(author);

        books.add(book1);

        Book book2 = new Book();
        book2.setTitle("Как");
        book2.setSemester(1);
        book2.setFaculty(Faculty.FTR);
        book2.setDownloadLink("asd");
        book2.setId((long) 3);
        book2.setAuthor(author);

        books.add(book2);
    }

    private void initializeAdapter() {
        BooksAdapter adapter = new BooksAdapter(books);
        rvBooks.setAdapter(adapter);
    }
}