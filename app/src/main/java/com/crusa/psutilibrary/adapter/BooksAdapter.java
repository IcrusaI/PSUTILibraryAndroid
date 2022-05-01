package com.crusa.psutilibrary.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crusa.psutilibrary.R;
import com.crusa.psutilibrary.model.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder>{
    List<Book> books;

    public BooksAdapter(List<Book> books) {
        this.books = books;
    }

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

    @Override
    public void onBindViewHolder(BooksViewHolder booksViewHolder, int i) {
        booksViewHolder.title.setText(books.get(i).getTitle());
        booksViewHolder.description.setText(books.get(i).getAuthor().getName());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class BooksViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView description;

        BooksViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.bookItem);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
        }
    }

}