package com.example.mitali.helloworld;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tts1;
    int res;
    EditText et;
    String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);

        tts1 = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS)
                {
                    res = tts1.setLanguage(Locale.ENGLISH);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Supported", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void action1(View v){
        switch(v.getId())
        {
            case R.id.speak:
                if(res==TextToSpeech.LANG_MISSING_DATA||res==TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(getApplicationContext(),"Not Supported", Toast.LENGTH_SHORT).show();
                }
                else
                {
                        text = et.getText().toString();
                        tts1.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
            case R.id.stop:
                if(tts1!=null)
                {
                    tts1.stop();
                }
                break;
        }
    }


}
