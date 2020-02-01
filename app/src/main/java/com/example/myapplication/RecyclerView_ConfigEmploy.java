package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_ConfigEmploy {
    private Context mContext;
    private BooksAdapter mBooksAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<EmployementFirebase> employs, List<String> keys)
    {
        mContext = context;
        mBooksAdapter = new BooksAdapter(employs , keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mBooksAdapter);
    }

    class BookItemView extends RecyclerView.ViewHolder{
        private TextView mCompany;
        private TextView mSalary;
        private TextView mRequirements;
        private TextView mJoin;
        private String key;

        /*public BookItemView(@NonNull View itemView) {
            super(itemView);
        }*/
        public BookItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mContext).inflate(R.layout.books_list_item, parent, false));

            mCompany = (TextView) itemView.findViewById(R.id.title_txtView);
            mSalary = (TextView) itemView.findViewById(R.id.author_txtView);
            mRequirements = (TextView) itemView.findViewById(R.id.category_txtView);
            mJoin = (TextView) itemView.findViewById(R.id.isbn_txtView);
        }
        public void bind(EmployementFirebase employ, String key)
        {
            mCompany.setText(employ.getCompany());
            mSalary.setText(employ.getSalary());
            mRequirements.setText(employ.getRequirements());
            mJoin.setText(employ.getJoin());
            this.key = key;
        }
    }
    class BooksAdapter extends RecyclerView.Adapter<BookItemView>
    {
        private List<EmployementFirebase> mBookList;
        private List<String> mKeys;

        public BooksAdapter(List<EmployementFirebase> mBookList, List<String> mKeys) {
            this.mBookList = mBookList;
            this.mKeys = mKeys;
        }

        @Override
        public BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BookItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BookItemView holder, int position) {
            holder.bind(mBookList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }
    }
}
