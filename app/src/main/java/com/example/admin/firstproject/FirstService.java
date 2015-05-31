package com.example.admin.firstproject;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class FirstService extends Service {
    public FirstService() {

    }

    public class LocalBinder extends Binder{
        public FirstService getService(){
            return FirstService.this;
        }
    }

    private final IBinder mBinder = new LocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    MediaPlayer mMediaPlayer;
    public void startPlayer(){
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.drawable.meyeu);
        mMediaPlayer.start();
    }

    public void stopPlayer(){
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }
}
