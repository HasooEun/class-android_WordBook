package com.example.hasoo.wordbook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Word> wordArrayList = new ArrayList<Word>();

        wordArrayList.add(new Word("abandon", "버리다"));
        wordArrayList.add(new Word("abnormal", "비정상적인"));
        wordArrayList.add(new Word("abolish", "폐지하다"));
        wordArrayList.add(new Word("absolute", "절대적인"));

        WordAdapter wordAdapter = new WordAdapter(wordArrayList, this);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(wordAdapter);
    }
}

class WordAdapter extends BaseAdapter{

    ArrayList<Word> wordArrayList;
    Context context;

    WordAdapter(ArrayList<Word> wordArrayList, Context context){
        this.wordArrayList = wordArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return wordArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = View.inflate(context, R.layout.word_layout, null);

        TextView textView = (TextView)convertView.findViewById(R.id.textView);
        TextView textView2= (TextView)convertView.findViewById(R.id.textView2);

        Word word = wordArrayList.get(position);
        textView.setText(word.word);
        textView2.setText(word.meaning);

        return convertView;
    }
}
