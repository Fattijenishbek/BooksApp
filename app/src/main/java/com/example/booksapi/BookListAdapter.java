package com.example.booksapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    private static final String LOG_TAG = BookListAdapter.class.getSimpleName();
    private final ArrayList<Book> mValues;
    private final Context mContext;

    public BookListAdapter(ArrayList<Book> items, Context context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_booklist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).title);
        String authorsString = "by " + mValues.get(position).authors;
        holder.mAuthorsView.setText(authorsString);
        holder.mRatingView.setText(mValues.get(position).rating);
        holder.mPublishedDateView.setText(mValues.get(position).publishedDate);
        holder.mPagesView.setText(mValues.get(position).pages);
        String smallThumbnailLink = mValues.get(position).smallThumbnailLink;
        Picasso.with(mContext).load(smallThumbnailLink.replace("http","https")).into(holder.mBookCoverView);

    }

    @Override
    public int getItemCount() {
        if (mValues != null) {
            return mValues.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitleView;
        public final TextView mAuthorsView;
        public final ImageView mBookCoverView;
        public final TextView mRatingView;
        public final TextView mPublishedDateView;
        public final TextView mPagesView;
        public Book mItem;

        public ViewHolder(View view) {
            super(view);
            mTitleView = (TextView) view.findViewById(R.id.title);
            mAuthorsView = (TextView) view.findViewById(R.id.authors);
            mBookCoverView = (ImageView) view.findViewById(R.id.book_cover);
            mRatingView = (TextView) view.findViewById(R.id.rating);
            mPublishedDateView = (TextView) view.findViewById(R.id.publishedDate);
            mPagesView = (TextView) view.findViewById(R.id.pages);
        }
    }
}
