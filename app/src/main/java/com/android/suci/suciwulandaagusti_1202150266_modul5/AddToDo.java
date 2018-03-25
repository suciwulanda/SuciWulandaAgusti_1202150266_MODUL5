package com.android.suci.suciwulandaagusti_1202150266_modul5;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    private EditText ToDo, Description, Priority;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        //mengatur title menjadi add to do
        setTitle("Add To Do");

        //merefer semua variabel yang ada
        ToDo = (EditText) findViewById(R.id.edt_Todo);
        Description = (EditText) findViewById(R.id.edt_Desc);
        Priority = (EditText) findViewById(R.id.edt_Priority);
        db = new Database(this);
    }

    @Override
    public void onBackPressed() {
        //membuat intent menuju MainActivity
        Intent intent = new Intent(AddToDo.this, MainActivity.class);
        //untuk memulai intent
        startActivity(intent);
        //untuk menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    public void addTodo(View view) {
        //kondisi apabila data todoname, deskripsi dan prioritas di isi,
        if (db.inputdata(new AddData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //akan menampilkan toast bahwa data telah berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List Ditambahkan !", Toast.LENGTH_SHORT).show();
            //intent atau berpindah ke mainActivity
            startActivity(new Intent(AddToDo.this, MainActivity.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast yang memberitahukan bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "List tidak boleh kosong", Toast.LENGTH_SHORT).show();
            //mengatur semua edit text menjadi kosong
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }

}
