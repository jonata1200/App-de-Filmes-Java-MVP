package com.example.appdefilmesjava.ui.Video;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdefilmesjava.R;
import com.example.appdefilmesjava.databinding.ActivityVideoBinding;

public class Video extends AppCompatActivity {

    private ActivityVideoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String video = getIntent().getExtras().getString("video");

        binding.videoView.setMediaController(new MediaController(this));
        binding.videoView.setVideoURI(Uri.parse(video));
        binding.videoView.requestFocus();
        binding.videoView.start();

    }
}