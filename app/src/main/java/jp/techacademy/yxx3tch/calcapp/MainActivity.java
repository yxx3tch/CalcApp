package jp.techacademy.yxx3tch.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1, mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText)findViewById(R.id.editText1);
        mEditText2 = (EditText)findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);

        try {
            // 計算に用いる数値を取得
            intent.putExtra("VALUE1", Float.parseFloat(mEditText1.getText().toString()));
            intent.putExtra("VALUE2", Float.parseFloat(mEditText2.getText().toString()));
        }catch(NumberFormatException e) {
            // 数値が入力されていない場合アラートを表示
            showAlertDialog();
            return;
        }

        // 四則演算の種類を判定
        if(v.getId() == R.id.button1) {
            intent.putExtra("CALC_TYPE", "plus");
        }else if(v.getId() == R.id.button2) {
            intent.putExtra("CALC_TYPE", "minus");
        }else if(v.getId() == R.id.button3) {
            intent.putExtra("CALC_TYPE", "times");
        }else if(v.getId() == R.id.button4) {
            intent.putExtra("CALC_TYPE", "divide");
        }

        startActivity(intent);
    }

    private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラー");
        alertDialogBuilder.setMessage("数値を入力して下さい。");

        // OKボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
