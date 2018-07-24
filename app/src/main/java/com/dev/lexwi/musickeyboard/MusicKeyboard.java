package com.dev.lexwi.musickeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static android.content.ContentValues.TAG;


public class MusicKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener, SoundPool.OnLoadCompleteListener {

    final String LOG_TAG = "myLogs";
    public static final String TAG = "KEYBOARD";
    final int MAX_STREAMS = 10;
    SoundPool sp = null;
    int[] streamId;
    int[] sounds;
    int soundIdExplosion;


    int streamIDShot;
    int streamIDExplosion;

    public enum KEYS_TYPE {
        SYMBOLS, ENGLISH, RUSSIAN
    }
    private KeyboardView mKeyboardView;
    private Keyboard mKeyboard;
    private KEYS_TYPE mCurrentLocale;
    private KEYS_TYPE mPreviousLocale;
     public boolean isCapsOn = true;

    @SuppressLint("InflateParams")
    @Override
    public View onCreateInputView() {
        sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(this);
        sounds = new int[8];
        streamId = new int[8];
        sounds[0] = sp.load(this, R.raw.s1, 1);
        sounds[1] = sp.load(this, R.raw.s2, 1);
        sounds[2] = sp.load(this, R.raw.s3, 1);
        sounds[3] = sp.load(this, R.raw.s4, 1);
        sounds[4] = sp.load(this, R.raw.s5, 1);
        sounds[5] = sp.load(this, R.raw.s6, 1);
        sounds[6] = sp.load(this, R.raw.s7, 1);
        sounds[7] = sp.load(this, R.raw.s8, 1);

        mKeyboardView = (MusicKeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        ((MusicKeyboardView)mKeyboardView).setMk(this);
        mCurrentLocale = KEYS_TYPE.RUSSIAN;
        mKeyboard = getKeyboard(mCurrentLocale);
        mKeyboard.setShifted(isCapsOn);
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setOnKeyboardActionListener(this);
        return mKeyboardView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        Log.d(LOG_TAG, "onLoadComplete, sampleId = " + sampleId + ", status = " + status);
    }
    /**
     * @param locale - keys of keyboard
     * @return localized keyboard
     */
    private Keyboard getKeyboard(KEYS_TYPE locale) {
        switch (locale) {
            case RUSSIAN:
                return new Keyboard(this, R.xml.ru_ru_keyboard);
            case ENGLISH:
                return new Keyboard(this, R.xml.en_us_keyboard);
            case SYMBOLS:
                return new Keyboard(this, R.xml.symbols_keyboard);
            default:
                return new Keyboard(this, R.xml.en_us_keyboard);
        }
    }

    @Override
    public void onPress(int i) {
        Log.d(TAG, "onPress " + i;

        switch (i) {
            case 1081:
                streamId[0]= sp.play(sounds[0], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1094:
                streamId[4]= sp.play(sounds[4], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1091:
                streamId[1]= sp.play(sounds[1], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1082:
                streamId[5]= sp.play(sounds[5], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1077:
                streamId[1]= sp.play(sounds[1], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1085:
                streamId[5]= sp.play(sounds[5], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1075:
                streamId[1]= sp.play(sounds[1], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1096:
                streamId[4]= sp.play(sounds[4], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1097:
                streamId[0]= sp.play(sounds[0], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1079:
                streamId[4]= sp.play(sounds[4], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1093:
                streamId[0]= sp.play(sounds[0], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1092:
                streamId[1]= sp.play(sounds[1], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1099:
                streamId[5]= sp.play(sounds[5], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1074:
                streamId[2]= sp.play(sounds[2], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1072:
                streamId[6]= sp.play(sounds[6], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1087:
                streamId[2]= sp.play(sounds[2], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1088:
                streamId[6]= sp.play(sounds[6], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1086:
                streamId[2]= sp.play(sounds[2], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1083:
                streamId[5]= sp.play(sounds[5], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1076:
                streamId[1]= sp.play(sounds[1], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1078:
                streamId[5]= sp.play(sounds[5], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1101:
                streamId[1]= sp.play(sounds[1], 0.5f, 0.5f, 0, 0, 1);
                break;
            case -1:
                streamId[3]= sp.play(sounds[2], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1103:
                streamId[6]= sp.play(sounds[6], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1095:
                streamId[3]= sp.play(sounds[3], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1089:
                streamId[0]= sp.play(sounds[0], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1084:
                streamId[3]= sp.play(sounds[3], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1080:
                streamId[0]= sp.play(sounds[0], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1090:
                streamId[3]= sp.play(sounds[3], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1100:
                streamId[6]= sp.play(sounds[6], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1073:
                streamId[2]= sp.play(sounds[2], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 1102:
                streamId[6]= sp.play(sounds[6], 0.5f, 0.5f, 0, 0, 1);
                break;
            case -5:
                streamId[2]= sp.play(sounds[2], 0.5f, 0.5f, 0, 0, 1);
                break;
            case -3:
                streamId[3]= sp.play(sounds[3], 0.5f, 0.5f, 0, 0, 1);
                break;
            case -2:
                streamId[5]= sp.play(sounds[5], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 32:
                streamId[4]= sp.play(sounds[4], 0.5f, 0.5f, 0, 0, 1);
                break;
            case 46:
                streamId[3]= sp.play(sounds[3], 0.5f, 0.5f, 0, 0, 1);
                break;
            case -4:
                streamId[3]= sp.play(sounds[3], 0.5f, 0.5f, 0, 0, 1);
                break;
        }
    }

    @Override
    public void onRelease(int i) {

        Log.d(TAG, "onRelease " + i);

        switch (i) {
            case 1081:
                stopAfterDelay(streamId[0]);
                break;
            case 1094:
                stopAfterDelay(streamId[4]);
                break;
            case 1091:
                stopAfterDelay(streamId[1]);
                break;
            case 1082:
                stopAfterDelay(streamId[5]);
                break;
            case 1077:
                stopAfterDelay(streamId[1]);
                break;
            case 1085:
                stopAfterDelay(streamId[5]);
                break;
            case 1075:
                stopAfterDelay(streamId[1]);
                break;
            case 1096:
                stopAfterDelay(streamId[4]);
                break;
            case 1097:
                stopAfterDelay(streamId[0]);
                break;
            case 1079:
                stopAfterDelay(streamId[4]);
                break;
            case 1093:
                stopAfterDelay(streamId[0]);
                break;
            case 1092:
                stopAfterDelay(streamId[1]);
                break;
            case 1099:
                stopAfterDelay(streamId[5]);
                break;
            case 1074:
                stopAfterDelay(streamId[2]);
                break;
            case 1072:
                stopAfterDelay(streamId[6]);
                break;
            case 1087:
                stopAfterDelay(streamId[2]);
                break;
            case 1088:
                stopAfterDelay(streamId[6]);
                break;
            case 1086:
                stopAfterDelay(streamId[2]);
                break;
            case 1083:
                stopAfterDelay(streamId[5]);
                break;
            case 1076:
                stopAfterDelay(streamId[1]);
                break;
            case 1078:
                stopAfterDelay(streamId[5]);
                break;
            case 1101:
                stopAfterDelay(streamId[1]);
                break;
            case -1:
                stopAfterDelay(streamId[2]);
                break;
            case 1103:
                stopAfterDelay(streamId[6]);
                break;
            case 1095:
                stopAfterDelay(streamId[3]);
                break;
            case 1089:
                stopAfterDelay(streamId[0]);
                break;
            case 1084:
                stopAfterDelay(streamId[3]);
                break;
            case 1080:
                stopAfterDelay(streamId[0]);
                break;
            case 1090:
                stopAfterDelay(streamId[3]);
                break;
            case 1100:
                stopAfterDelay(streamId[6]);
                break;
            case 1073:
                stopAfterDelay(streamId[2]);
                break;
            case 1102:
                stopAfterDelay(streamId[6]);
                break;
            case -5:
                stopAfterDelay(streamId[2]);
                break;
            case -3:
                stopAfterDelay(streamId[3]);
                break;
            case -2:
                stopAfterDelay(streamId[5]);
                break;
            case 32:
                stopAfterDelay(streamId[4]);
                break;
            case 46:
                stopAfterDelay(streamId[3]);
                break;
            case -4:
                stopAfterDelay(streamId[3]);
                break;
        }
    }

    public void stopAfterDelay(final int stream)
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sp.stop(stream);
            }
        }, 1500);
    }
    @Override
    public void onKey(int primaryCode, int[] ints) {
        Log.d(TAG, "onKey " + primaryCode);

        Log.d(TAG, "onKeys " + ints);
        InputConnection ic = getCurrentInputConnection();


        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                handleShift();
                break;
            case Keyboard.KEYCODE_DONE:
                mKeyboardView.clearFocus();
                break;
            case -3:
                handleSymbolsSwitch();
                break;
            case Keyboard.KEYCODE_MODE_CHANGE:
                handleLanguageSwitch();
                break;
            default:
                char code = (char) primaryCode;
                if (Character.isLetter(code) && isCapsOn) {
                    code = Character.toUpperCase(code);
                }

                ic.commitText(String.valueOf(code), 1);
                break;
        }
    }

    @Override
    public void onText(CharSequence charSequence) {
        Log.d(TAG, "onText ");
    }

    @Override
    public void swipeLeft() {
        Log.d(TAG, "swipeLeft ");
    }

    @Override
    public void swipeRight() {
        Log.d(TAG, "swipeRight ");
    }

    @Override
    public void swipeDown() {
        Log.d(TAG, "swipeDown ");
    }

    @Override
    public void swipeUp() {
        Log.d(TAG, "swipeUp ");
    }

    private void handleSymbolsSwitch() {
        if (mCurrentLocale != KEYS_TYPE.SYMBOLS) {
            mKeyboard = getKeyboard (KEYS_TYPE.SYMBOLS);
            mPreviousLocale = mCurrentLocale;
            mCurrentLocale = KEYS_TYPE.SYMBOLS;
        } else {
            mKeyboard = getKeyboard(mPreviousLocale);
            mCurrentLocale = mPreviousLocale;
            mKeyboard.setShifted(isCapsOn);
        }
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.invalidateAllKeys();
    }

    private void handleShift() {
        isCapsOn = !isCapsOn;
        mKeyboard.setShifted(isCapsOn);
        mKeyboardView.invalidateAllKeys();
    }

    private void handleLanguageSwitch() {
        if (mCurrentLocale == KEYS_TYPE.RUSSIAN) {
            mCurrentLocale = KEYS_TYPE.ENGLISH;
            mKeyboard = getKeyboard(KEYS_TYPE.ENGLISH);
        } else {
            mCurrentLocale = KEYS_TYPE.RUSSIAN;
            mKeyboard = getKeyboard(KEYS_TYPE.RUSSIAN);
        }

        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboard.setShifted(isCapsOn);
        mKeyboardView.invalidateAllKeys();
    }}
