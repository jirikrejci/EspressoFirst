package com.jirikrejci.espressofirst;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jirikrejci.espressofirst.R;
import com.jirikrejci.espressofirst.SecondActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.inputField);
        switch (view.getId()) {
            case R.id.changeText:

                editText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("input", editText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

                break;
        }

    }
}
