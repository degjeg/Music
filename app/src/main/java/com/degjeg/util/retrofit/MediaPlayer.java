package com.degjeg.util.retrofit;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by Administrator on 2017-11-16.
 */

public class MediaPlayer implements
        android.media.MediaPlayer.OnErrorListener,
        android.media.MediaPlayer.OnPreparedListener,
        AudioManager.OnAudioFocusChangeListener,
        android.media.MediaPlayer.OnCompletionListener {

    private android.media.MediaPlayer mMediaPlayer;


    public MediaPlayer(Context context) {
        mMediaPlayer = new android.media.MediaPlayer();
        mMediaPlayer.setOnErrorListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        ((AudioManager) context.getSystemService(Context.AUDIO_SERVICE)).
                requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

    }

    public void playSong(String path) {
        try {
            stopSong();
            mMediaPlayer.reset();//idle
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void pausePlay() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }


    public void continuePlay() {
        if (mMediaPlayer != null && !mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
        }
    }


    public void stopSong() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
        }
    }

    public void seekPlaySong(int progress) {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.seekTo(progress);
        }
    }

    @Override
    public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(android.media.MediaPlayer mp) {

    }

    @Override
    public void onAudioFocusChange(int focusChange) {

    }

    @Override
    public void onCompletion(android.media.MediaPlayer mp) {

    }

    public int getCurrentPos() {
        return mMediaPlayer.getCurrentPosition();
    }

    public int getTotalLength() {
        return mMediaPlayer.getDuration();
    }

    public boolean isPlaying() {

       return mMediaPlayer.isPlaying();
    }
}
