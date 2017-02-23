package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by sledz on 12.02.17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    private int mColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super (context, 0,words);
        mColorResourceId=colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        mColor = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(mColor);

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon_view);
        if (currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageResId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}