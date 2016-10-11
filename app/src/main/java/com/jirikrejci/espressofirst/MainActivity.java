package com.jirikrejci.espressofirst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @BindView(R.id.inputField) TextView tvEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:

                tvEditText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("input", tvEditText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

                break;
            case R.id.btnSetError:
                tvEditText.setError(getString(R.string.err_input_value));
                break;

        }

    }
}
