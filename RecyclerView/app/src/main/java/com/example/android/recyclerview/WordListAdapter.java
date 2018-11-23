package com.example.android.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList){
        mWordList = wordList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i) {
        String mCurrent = mWordList.get(i);
        wordViewHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String element = mWordList.get(pos);
            mWordList.set(pos, "Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }

        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
    }
}
