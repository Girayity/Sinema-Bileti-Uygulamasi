package deu.csc.lecture.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // bilet al buttonları yardımıyla her bir film için yeni activity'ye geçmeyi sağlayan fonksiyon
    public void biletAl(View v) {
        Intent intent = new Intent(this, Seans.class);
        // film isimlerini seçilen filme göre 2.activity'ye verir
        if (v.getId() == R.id.bilet1) {
            intent.putExtra("film adi", getString(R.string.film1));
        } else if (v.getId() == R.id.bilet2) {
            intent.putExtra("film adi", getString(R.string.film2));
        } else if (v.getId() == R.id.bilet3) {
            intent.putExtra("film adi", getString(R.string.film3));
        } else if (v.getId() == R.id.bilet4) {
            intent.putExtra("film adi", getString(R.string.film4));
        } else if (v.getId() == R.id.bilet5) {
            intent.putExtra("film adi", getString(R.string.film5));
        } else if (v.getId() == R.id.bilet6) {
            intent.putExtra("film adi", getString(R.string.film6));
        }
        startActivity(intent);
    }
}
