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
        booksViewHolder.title.setText(books.get(i).getTitle());

        String description = books.get(i).getAuthor().getName() + " · "
                + books.get(i).getFaculty() + " · "
                + books.get(i).getSemester() + " семестр.";
        booksViewHolder.description.setText(description);
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