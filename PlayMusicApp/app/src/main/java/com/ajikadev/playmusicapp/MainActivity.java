package com.ajikadev.playmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
  private static final int REQUEST_PERMISSIONS_CODE = 123;
  private Button playButton, stopButton, pauseButton, nextButton, previousButton;
  private MediaPlayer mediaPlayer;
  private int currentSongIndex = 0;
  private String[] audioFilePaths;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    playButton = findViewById(R.id.btnPlay);
    stopButton = findViewById(R.id.btnStop);
    pauseButton = findViewById(R.id.btnPause);
    nextButton = findViewById(R.id.btnNext);
    previousButton = findViewById(R.id.btnPrevious);

    playButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (checkPermissions()) {
          fetchAudioFiles();
          playSong();
        } else {
          requestPermissions();
        }
      }
    });

    stopButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        stopSong();
      }
    });

    pauseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        pauseSong();
      }
    });

    nextButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        playNextSong();
      }
    });

    previousButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        playPreviousSong();
      }
    });
  }

  private boolean checkPermissions() {
    int readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
    return readPermission == PackageManager.PERMISSION_GRANTED;
  }

  private void requestPermissions() {
    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSIONS_CODE);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_PERMISSIONS_CODE) {
      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        fetchAudioFiles();
      } else {
        Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
      }
    }
  }

  private void fetchAudioFiles() {
    Toast.makeText(getApplicationContext(), "Fetching audio files...", Toast.LENGTH_SHORT).show();

    String[] projection = new String[]{
      MediaStore.Audio.AlbumColumns.ALBUM,
      MediaStore.Audio.Media.DATA
    };

    Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

    CursorLoader cursorLoader = new CursorLoader(getApplicationContext(), uri, projection,
      null, null, null);

    Cursor cursor = cursorLoader.loadInBackground();

    if (cursor != null && cursor.moveToFirst()) {
      audioFilePaths = new String[cursor.getCount()];
      int i = 0;
      do {
        String audioFilePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
        audioFilePaths[i++] = audioFilePath;
      } while (cursor.moveToNext());
      cursor.close();
    }
  }

  private void playSong() {
    if (mediaPlayer == null) {
      if (audioFilePaths != null && audioFilePaths.length > 0) {
        try {
          mediaPlayer = new MediaPlayer();
          mediaPlayer.setDataSource(audioFilePaths[currentSongIndex]);
          mediaPlayer.prepare();
          mediaPlayer.start();
          Toast.makeText(getApplicationContext(), "Playing: " + audioFilePaths[currentSongIndex], Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        Toast.makeText(getApplicationContext(), "No audio files found", Toast.LENGTH_SHORT).show();
      }
    } else {
      mediaPlayer.start();
    }
  }

  private void stopSong() {
    if (mediaPlayer != null) {
      mediaPlayer.stop();
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }

  private void pauseSong() {
    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
      mediaPlayer.pause();
    }
  }

  private void playNextSong() {
    if (mediaPlayer != null && currentSongIndex < audioFilePaths.length - 1) {
      stopSong();
      currentSongIndex++;
      playSong();
    } else {
      Toast.makeText(getApplicationContext(), "No next song available", Toast.LENGTH_SHORT).show();
    }
  }

  private void playPreviousSong() {
    if (mediaPlayer != null && currentSongIndex > 0) {
      stopSong();
      currentSongIndex--;
      playSong();
    } else {
      Toast.makeText(getApplicationContext(), "No previous song available", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    stopSong();
  }
}
