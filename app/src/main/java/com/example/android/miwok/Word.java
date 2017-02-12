package com.example.android.miwok;

import android.media.Image;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private Image mImage;

    public Word(String defaultTranslation, String miwokTranslation){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation=defaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
}
