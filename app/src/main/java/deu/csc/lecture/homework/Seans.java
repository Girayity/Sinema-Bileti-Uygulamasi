package deu.csc.lecture.homework;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Seans extends Activity {
    String film = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seans);

        Intent intent = getIntent();
        film = intent.getStringExtra("film adi");// film adinin value'si alındı
        ((TextView) findViewById(R.id.seanslar)).setText(film + " Filmi İçin Seanslar");// textview'a filmin adı ve gerekli string eklendi
        visibility();
    }

    // activity yaratıldığında çalışır ve seansların daha önce seçilip seçilmediğini kontrol eder. Filme ait seans seçilmemişse o seans default olarak true değeri alır yani seçilebilir olur
    private void visibility() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        Button seans = (Button) findViewById(R.id.seans1);
        seans.setEnabled(prefs.getBoolean(film + seans.getText(), true));
        seans = (Button) findViewById(R.id.seans2);
        seans.setEnabled(prefs.getBoolean(film + seans.getText(), true));
        seans = (Button) findViewById(R.id.seans3);
        seans.setEnabled(prefs.getBoolean(film + seans.getText(), true));
        seans = (Button) findViewById(R.id.seans4);
        seans.setEnabled(prefs.getBoolean(film + seans.getText(), true));
        seans = (Button) findViewById(R.id.seans5);
        seans.setEnabled(prefs.getBoolean(film + seans.getText(), true));
    }

    // her bir buton için seans seçimi sonrası ekrana ileti veren ve seans seçimlerini kaydetmeyi sağlayan fonksiyon
    public void satınAl(View v) {
        Button button = (Button) v;
        v.setEnabled(false);
        Toast.makeText(getApplicationContext(), button.getText() + " seansı için bilet aldınız.",
                Toast.LENGTH_LONG).show();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putBoolean(film + button.getText(), false);// butonların, seans seçimi yapıldıktan sonra görünürlüğünü ayarlar
        prefsEditor.apply();
    }
}
