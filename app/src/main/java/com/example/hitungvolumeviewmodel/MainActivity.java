package com.example.hitungvolumeviewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPanjang;
    private EditText editTextLebar;
    private EditText editTextTinggi;
    private TextView textViewHasil;
    private Button btHitung;
    private VolumeViewModel volumeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengaitkan variabel dengan komponen UI di layout
        editTextPanjang = findViewById(R.id.editTextPanjang);
        editTextLebar = findViewById(R.id.editTextLebar);
        editTextTinggi = findViewById(R.id.editTextTinggi);
        textViewHasil = findViewById(R.id.tvHasil);
        btHitung = findViewById(R.id.button);

        // Menginisialisasi VolumeViewModel
        volumeViewModel = new ViewModelProvider(this).get(VolumeViewModel.class);

        // Menetapkan listener untuk tombol hitung
        btHitung.setOnClickListener(v->{
            // Mengambil nilai dari EditText dan mengonversinya menjadi double
            double panjang = Double.parseDouble(editTextPanjang.getText().toString());
            double lebar = Double.parseDouble(editTextLebar.getText().toString());
            double tinggi = Double.parseDouble(editTextTinggi.getText().toString());
            // Memanggil metode hitungVolume di ViewModel untuk menghitung volume
            volumeViewModel.hitungVolume(panjang, lebar, tinggi);
        });

        // Mengamati perubahan hasil volume dan memperbarui TextView
        volumeViewModel.getVolumeResult().observe(this, volume -> textViewHasil.setText(String.valueOf(volume)));
    }
}