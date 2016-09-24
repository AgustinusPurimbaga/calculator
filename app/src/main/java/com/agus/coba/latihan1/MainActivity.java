package com.agus.coba.latihan1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public String str = "";
    Character op = 'q';
    double hasil;
    double hasilTemp;
    EditText lihatHasil;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lihatHasil = (EditText) findViewById(R.id.editText);
    }

    public void tombol0click(View v) { insert(0); }
    
    public void tombol1click(View v) { insert(1); }

    public void tombol2click(View v) { insert(2); }

    public void tombol3click(View v) { insert(3); }

    public void tombol4click(View v) { insert(4); }

    public void tombol5click(View v) { insert(5); }

    public void tombol6click(View v) { insert(6); }

    public void tombol7click(View v) { insert(7); }

    public void tombol8click(View v) { insert(8); }

    public void tombol9click(View v) { insert(9); }

    public void tombolTitikclick(View v){ insert("."); }

    public void tombolResetclick(View v){ reset(); }

    public void tombolKaliclick(View v){
        perform();
        op = '*';
    }

    public void tombolTambahclick(View v){
        perform();
        op = '+';
    }

    public void tombolKurangclick(View v){
        perform();
        op = '-';
    }

    public void tombolBagiclick(View v){
        perform();
        op = '/';
    }

    public void tombolPersenclick(View v){
        perform();
        op = '%';
        hitung();
    }

    public void tombolAkarclick(View v){
        perform();
        op = 'a';
        hitung();
    }

    public void tombolKuadratclick(View v){
        perform();
        op = '^';
        hitung();
    }

    public void tombolHasilclick(View v){
        hitung();
    }

    public void tombolHapusclick(View v){

        String text = lihatHasil.getText().toString();
        if(text.length() <= 1){
            str = "";
            op = 'q';
            hasil = 0;
            hasilTemp = 0;
            lihatHasil.setText("");
        }
        else if(text.length() >= 1) {
            lihatHasil.setText(text.substring(0, text.length() - 1));
            lihatHasil.setSelection(lihatHasil.getText().length());
        }
    }

    private void insert(int j) {
        insert(Integer.toString(j));
        hasil = Double.parseDouble(str);
        lihatHasil.setText(str);
    }

    private void insert(String s) {
        str = str + s;
        lihatHasil.setText(str);
    }

    private void reset() {
        str = "";
        op = 'q';
        hasil = 0;
        hasilTemp = 0;
        lihatHasil.setText("");
    }

    private void perform() {
        str = "";
        hitungNoShow();
        hasilTemp = hasil;

    }

    private void hitung() {
        if(op == '+')
            hasil = hasilTemp+hasil;
        else if(op == '-')
            hasil = hasilTemp-hasil;
        else if(op == '/')
            hasil = hasilTemp/hasil;
        else if(op == '*')
            hasil = hasilTemp*hasil;
        else if(op == '^')
            hasil = (float) Math.pow(hasilTemp,2);
        else if(op == 'a')
            hasil = (float) Math.sqrt(hasilTemp);
        else if(op == '%')
            hasil = hasilTemp/100;
        lihatHasil.setText(""+hasil);

    }

    private void hitungNoShow() {
        if(op == '+')
            hasil = hasilTemp+hasil;
        else if(op == '-')
            hasil = hasilTemp-hasil;
        else if(op == '/')
            hasil = hasilTemp/hasil;
        else if(op == '*')
            hasil = hasilTemp*hasil;
        else if(op == '^')
            hasil = (float) Math.pow(hasilTemp,2);
        else if(op == 'a')
            hasil = (float) Math.sqrt(hasilTemp);
        else if(op == '%')
            hasil = hasilTemp/100;

    }
}

