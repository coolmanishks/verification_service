package com.example.lenovo.testing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.testing.MainActivity;
import com.example.lenovo.testing.R;


/**
 * Created by lenovo on 23-Mar-18.
 */
public class Verification extends Activity
{
    Button button;
    public static Context context;
    MainActivity ma=new MainActivity();

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

//                if(ma.m==0) {
//                    ma.randomId();
//                }
//                else
//                    ma.middle();
            }
        });
    }
}
