package com.crusa.psutilibrary.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.crusa.psutilibrary.R;
import com.crusa.psutilibrary.model.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder>{
    List<Book> books;

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_books, viewGroup, false);
        BooksViewHolder pvh = new BooksViewHolder(v);
        return pvh;
    }

    public void setData(List<Book> books) {
        this.books = books;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BooksViewHolder booksViewHolder, int i) {
        booksViewHolder.bind(books.get(i), i);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class BooksViewHolder extends RecyclerView.ViewHolder {
        CardView cv = (CardView)itemView.findViewById(R.id.bookItem);
        TextView title = (TextView)itemView.findViewById(R.id.title);
        TextView description = (TextView)itemView.findViewById(R.id.description);
        TextView downloadBtn = (Button)itemView.findViewById(R.id.download_btn);

        BooksViewHolder(View itemView) {
            super(itemView);
        }

        void bind(Book book, int i) {
            title.setText(book.getTitle());

            description.setText(book.getAuthor().getName() + " · "
                    + book.getFaculty() + " · "
                    + book.getSemester() + " семестр.");

            downloadBtn.setId(i);

        }
    }

}