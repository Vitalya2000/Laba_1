package com.example.l1;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <Product> products = new ArrayList<Product>();
    ArrAdapter arrAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // создаем адаптер
        fillData();
        arrAdapter = new ArrAdapter(this, products);
        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(arrAdapter);
    }
        // генерируем данные для адаптера
        void fillData () {
            for (int i = 1; i <= 1000000; i++) {
                if (i % 2 == 0) {
                    products.add(new Product(Translator.fromIntToString(i), R.drawable.maz_2, 0xFFCCCCCC));
                } else {
                    products.add(new Product(Translator.fromIntToString(i), R.drawable.maz_3, 0xFFFFFFFF));
                }
                if (i == 50000) i = 950000;
            }
        }
        @Override
        public void onBackPressed () {
            // super.onBackPressed();
            openQuitDialog();
        }
        private void openQuitDialog () {

            AlertDialog.Builder quitDialog = new AlertDialog.Builder(MainActivity.this);
            quitDialog.setTitle("Выйти из приложения?");

            quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    finish();
                }
            });
            quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                }
            });

            quitDialog.show();
        }
    }







