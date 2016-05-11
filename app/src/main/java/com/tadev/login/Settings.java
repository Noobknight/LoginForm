package com.tadev.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

/**
 * Created by PC on 11/05/2016.
 */
public class Settings implements Parcelable {
    protected int colorBackground;
    protected int background;
    protected int icon;
    protected String firstFieldName;
    protected String secondsFieldName;
    protected boolean isBackgroundColor;
    protected int colorAlpha;
    protected boolean enableSocial;
    protected int colorTextButton;
    protected int colorBackgroundButton;


    public Settings() {
    }


    public void handleAttributes(Context context, AttributeSet attrs) {
        try {
            TypedArray typedArrs = context.obtainStyledAttributes(attrs, R.styleable.LoginForm);

            colorBackground = typedArrs.getColor(R.styleable.LoginForm_colorBackgroundForm, -1);
            if (colorBackground == -1) {
                colorBackground = ContextCompat.getColor(context, R.color.white);
            } else {
                isBackgroundColor = true;
            }
            background = typedArrs.getResourceId(R.styleable.LoginForm_backgroundForm, R.drawable.background);
            if (background == -1) {
                isBackgroundColor = true;
            }
            icon = typedArrs.getResourceId(R.styleable.LoginForm_iconLogin, -1);
            firstFieldName = typedArrs.getString(R.styleable.LoginForm_firstFieldName);
            if (typedArrs == null) {
                firstFieldName = context.getResources().getString(R.string.firstFieldName);
            }
            secondsFieldName = typedArrs.getString(R.styleable.LoginForm_secondsFieldName);
            if (typedArrs == null) {
                firstFieldName = context.getResources().getString(R.string.secondsFieldName);
            }

            colorAlpha = typedArrs.getColor(R.styleable.LoginForm_colorAlpha,
                    ContextCompat.getColor(context, R.color.default_color_alpha));
            enableSocial = typedArrs.getBoolean(R.styleable.LoginForm_enable_social, true);

            colorBackgroundButton = typedArrs.getColor(R.styleable.LoginForm_colorButtonLogin,
                    ContextCompat.getColor(context, R.color.white));

            colorTextButton = typedArrs.getColor(R.styleable.LoginForm_colorTextButton,
                    ContextCompat.getColor(context, R.color.colorPrimary));
            typedArrs.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public boolean isBackgroundColor() {
        return isBackgroundColor;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.colorBackground);
        dest.writeInt(this.background);
        dest.writeInt(this.icon);
        dest.writeString(this.firstFieldName);
        dest.writeString(this.secondsFieldName);
        dest.writeByte(isBackgroundColor ? (byte) 1 : (byte) 0);
        dest.writeInt(this.colorAlpha);
    }


    protected Settings(Parcel in) {
        this.colorBackground = in.readInt();
        this.background = in.readInt();
        this.icon = in.readInt();
        this.firstFieldName = in.readString();
        this.secondsFieldName = in.readString();
        this.isBackgroundColor = in.readByte() != 0;
        this.colorAlpha = in.readInt();
    }

    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel source) {
            return new Settings(source);
        }

        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };
}
