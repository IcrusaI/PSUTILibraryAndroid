package com.crusa.psutilibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.crusa.psutilibrary.adapter.BooksAdapter;
import com.crusa.psutilibrary.model.Author;
import com.crusa.psutilibrary.model.Book;
import com.crusa.psutilibrary.model.Faculty;
import com.crusa.psutilibrary.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BooksActivity extends Activity {

    private final static String TAG = "BooksActivity";

    RecyclerView rvBooks;
    BooksAdapter booksAdapter;
    private List<Book> books;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_books);

        rvBooks = findViewById(R.id.booksList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(llm);
        rvBooks.setHasFixedSize(false);

        initializeAdapter();
        initializeData();
    }

    private String faculty = null;
    private Integer semester = null;

    private void initializeData() {
        books = new ArrayList<Book>();

        List<Book> locBooks = new ArrayList<>();

        // Данные для тестов
        locBooks = testData();

        if (semester == null && faculty == null) {
            books.addAll(locBooks);
        } else {
            for (int i = 0; i < (int) locBooks.size(); i++) {
                Book book = locBooks.get(i);

                if (faculty != null && !book.getFaculty().name().equalsIgnoreCase(faculty)) {
                    continue;
                }

                if (semester != null && !book.getSemester().equals(semester)) {
                    continue;
                }

                books.add(book);
            }
        }

        booksAdapter.setData(books);
    }

    private List<Book> testData() {
        List<Book> locBooks = new ArrayList<>();

        Author author = new Author();
        author.setId((long) 1);
        author.setName("Антипова, Т. А.");

        Book book1 = new Book();
        book1.setTitle("Анализ и прогнозирование поведения временных рядов в физических, биологических и экономических системах");
        book1.setSemester(3);
        book1.setFaculty(Faculty.FBTO);
        book1.setDownloadLink("http://elib.psuti.ru/Antipova_Adyshirin-zade_Voronoj_Klyuev_Sokolova_analiz_i_prognozirovanie_povedeniya_vremennyh_ryadov_uchebnik_2021.pdf");
        book1.setId((long) 1);
        book1.setAuthor(author);

        locBooks.add(book1);

        Author author2 = new Author();
        author2.setId((long) 1);
        author2.setName("Николаев, Б. И.");

        Book book2 = new Book();
        book2.setTitle("Методы цифровой модуляции сигналов");
        book2.setSemester(2);
        book2.setFaculty(Faculty.FTR);
        book2.setDownloadLink("http://elib.psuti.ru/Nikolaev_Chingaeva_Borisenkov_metody_cifrovoj_modulyacii_signalov_lab_rabota_2021.pdf");
        book2.setId((long) 2);
        book2.setAuthor(author2);

        locBooks.add(book2);

        Book book5 = new Book();
        book5.setTitle("Спектры детерминированных сигналов");
        book5.setSemester(5);
        book5.setFaculty(Faculty.FIST);
        book5.setDownloadLink("http://elib.psuti.ru/Nikolaev_Chingaeva_Borisenkov_spektry_determinirovannyh_signalov_lab_rabota_2021.pdf");
        book5.setId((long) 5);
        book5.setAuthor(author2);

        locBooks.add(book5);

        return locBooks;
    }

    private void initializeAdapter() {
        booksAdapter = new BooksAdapter();
        rvBooks.setAdapter(booksAdapter);


        initializeFacultySpinnerAdapter();
        initializeSemesterSpinnerAdapter();
    }

    private void initializeFacultySpinnerAdapter() {
        // факультеты спинер
        Spinner spinner = findViewById(R.id.faculty_spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.faculties_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String data = (String)parent.getItemAtPosition(position);
                // Получаем выбранный объект
                if (data.equals("ALL")) {
                    faculty = null;
                } else {
                    faculty = (String) parent.getItemAtPosition(position);
                }

                initializeData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                initializeData();
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    private void initializeSemesterSpinnerAdapter() {
        Spinner spinner = findViewById(R.id.semestr_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.semesters_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String data = (String) parent.getItemAtPosition(position);
                // Получаем выбранный объект
                if (data.equals("ALL")) {
                    semester = null;
                } else {
                    semester = (int) parent.getItemAtPosition(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    public void clickButton(View view) {
    }
}