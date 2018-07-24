package com.dev.lexwi.musickeyboard;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import com.dev.lexwi.musickeyboard.MusicKeyboard;
import android.util.Log;

import java.util.List;
import java.util.Arrays;

/**
 * Created by lexwi on 22.02.2018.
 */

public class MusicKeyboardView extends KeyboardView{

    private Drawable backgroundimage;
    int[] SpecCodes = {-1,-5,-3,-101,32,13};
    MusicKeyboard mk;
    int[] BackSpaceCode = {-5};

    Drawable keyboard_background = getResources().getDrawable(R.drawable.keyboard_background);
    Drawable letter_bg = getResources().getDrawable(R.drawable.letter);
    Drawable bspace_bg = getResources().getDrawable(R.drawable.backspace_key);
    Drawable space_bg = getResources().getDrawable(R.drawable.space_key);
    Drawable shift_bg = getResources().getDrawable(R.drawable.shift_key);
    Drawable sym_key_bg = getResources().getDrawable(R.drawable.sym_key_icon);
    Drawable lang_key_bg = getResources().getDrawable(R.drawable.lang_key);
    Drawable enter_key_bg = getResources().getDrawable(R.drawable.enter_key);

    AssetManager mngr;
    public MusicKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mngr = context.getAssets();
    }

    public void setMk(MusicKeyboard mk_)
    {
        mk = mk_;
    }

    public MusicKeyboard getMk() {
        return mk;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mpaint = new Paint();
        Rect imageBounds = canvas.getClipBounds();

        Typeface tf = Typeface.createFromAsset(mngr,"fonts/main_font.otf");
        mpaint.setTypeface(tf); //to make all Bold. Choose Default to make all normal font
        mpaint.setTextAlign(Paint.Align.CENTER);
        mpaint.setTextSize(65); //in px
        keyboard_background.setBounds(0,0, imageBounds.width(), imageBounds.height());
        keyboard_background.draw(canvas);

        List<Keyboard.Key> keys = getKeyboard().getKeys();

        for (Keyboard.Key key : keys) {
            System.out.print(key.codes);
            if (key.label != null && !Arrays.asList(SpecCodes).contains(key.codes) ) {
                String keyLabel;
                keyLabel = key.label.toString();
                if(!mk.isCapsOn)
                    keyLabel = key.label.toString();
                else
                    keyLabel = key.label.toString().toUpperCase();

                letter_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                letter_bg.draw(canvas);
                
                canvas.drawText(keyLabel, (key.x + key.width/2), (key.y + key.height/2) + key.height/5, mpaint);
            }
            else if(key.codes[0] == -5)
            {
                bspace_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                bspace_bg.draw(canvas);
            }
            else if(key.codes[0] == 32)
            {
                space_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                space_bg.draw(canvas);
            }
            else if(key.codes[0] == -1)
            {
                shift_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                shift_bg.draw(canvas);
            }
            else if(key.codes[0] == -3)
            {
                sym_key_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                sym_key_bg.draw(canvas);
            }
            else if(key.codes[0] == -2)
            {
                lang_key_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                lang_key_bg.draw(canvas);
            }
            else if(key.codes[0] == -4)
            {
                enter_key_bg.setBounds(key.x + key.width/13, key.y + key.height/13, key.x + key.width - key.width/13, key.y + key.height - key.height/13);
                enter_key_bg.draw(canvas);
            }
        }
    }


}
