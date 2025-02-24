package com.example.hitungvolumeviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VolumeViewModel extends ViewModel {
    // Deklarasi MutableLiveData untuk menyimpan hasil volume
    private final MutableLiveData<Double> volumeResult = new MutableLiveData<>();

    // Metode untuk menghitung volume berdasarkan dimensi yang diberikan
    public void hitungVolume(double panjang, double lebar, double tinggi) {
        double volume = panjang * lebar * tinggi;
        volumeResult.setValue(volume);
    }

    // Metode untuk mengembalikan LiveData hasil volume
    public MutableLiveData<Double> getVolumeResult() {
        return volumeResult;
    }
}