package com.ngoctai.dmt.gamecuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBarone, seekBarTwo,seekBarThree;
    TextView  textViewdiemso;
    CheckBox checkBoxone , checkBoxtwo, checkBoxthree;
    ImageButton imageButtonPlay;
    int diem =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        seekBarone.setEnabled(false);
        seekBarTwo.setEnabled(false);
        seekBarThree.setEnabled(false);
        textViewdiemso.setText(diem +"");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {


                int random = 5;
                Random random1 = new Random(  );
                int numberone = random1.nextInt(random);
                int numbertwo = random1.nextInt(random);
                int numberthree = random1.nextInt(random);
                if (seekBarone.getProgress() >= seekBarone.getMax()   )  // chó thắng
                {
                    this.cancel();
                    imageButtonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this," DOG WIN",Toast.LENGTH_SHORT).show();

                    if (checkBoxone.isChecked())
                    {
                        textViewdiemso.setText(diem +10+"");
                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        textViewdiemso.setText(diem -10+"");
                        Toast.makeText(MainActivity.this," Bạn đoán sai rồi",Toast.LENGTH_SHORT).show();
                    }
                    batcheckBox();

                }
                if (seekBarTwo.getProgress() >= seekBarTwo.getMax()) //cừu thắng
                {   this.cancel();
                    Toast.makeText(MainActivity.this," SHEEP WIN",Toast.LENGTH_SHORT).show();
                    imageButtonPlay.setVisibility(View.VISIBLE);
                    if (checkBoxtwo.isChecked())
                    {
                        textViewdiemso.setText(diem +10+"");
                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        textViewdiemso.setText(diem -10+"");
                        Toast.makeText(MainActivity.this," Bạn đoán sai rồi",Toast.LENGTH_SHORT).show();
                    }
                    batcheckBox();
                }
                if (seekBarThree.getProgress() >= seekBarThree.getMax()) // ong thắng
                {   this.cancel();
                    Toast.makeText(MainActivity.this," BEE WIN",Toast.LENGTH_SHORT).show();
                    imageButtonPlay.setVisibility(View.VISIBLE);

                    if (checkBoxthree.isChecked())
                    {
                        textViewdiemso.setText(diem +10+"");
                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        textViewdiemso.setText(diem -10+"");
                        Toast.makeText(MainActivity.this," Bạn đoán sai rồi",Toast.LENGTH_SHORT).show();
                    }
                    batcheckBox();
                }
                seekBarone.setProgress(seekBarone.getProgress() +numberone);
                seekBarTwo.setProgress(seekBarTwo.getProgress() +numbertwo);
                seekBarThree.setProgress(seekBarThree.getProgress() +numberthree);

            }

            @Override
            public void onFinish() {

            }
        };
        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBarone.setProgress(0);
                seekBarTwo.setProgress(0);
                seekBarThree.setProgress(0);
                batcheckBox();
                if (checkBoxone.isChecked() || checkBoxtwo.isChecked()||checkBoxthree.isChecked()){

                imageButtonPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
                    tatcheckBox();
            }
                else{
                    Toast.makeText(MainActivity.this,"Vui lòng chọn 1 con vật ",Toast.LENGTH_SHORT).show();;
                }
            }
        });
        checkchoice ();
    }
    private  void  Anhxa()
    {
        seekBarone= (SeekBar) findViewById(R.id.seekBarOne);
        seekBarTwo= (SeekBar) findViewById(R.id.seekBarTwo);
        seekBarThree= (SeekBar) findViewById(R.id.seekBarthree);
        textViewdiemso = (TextView)findViewById(R.id.textView3);
        checkBoxone  =(CheckBox) findViewById(R.id.CHECKBOXone);
        checkBoxtwo = (CheckBox) findViewById(R.id.CHECKBOXtwo) ;
        checkBoxthree = (CheckBox)findViewById(R.id.CHECKBOXthree);
        imageButtonPlay  = (ImageButton) findViewById(R.id.imageButton2);
    }


    private void  checkchoice ()
    {
        checkBoxone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {   checkBoxtwo.setChecked(false);
                    checkBoxthree.setChecked(false);
                }
            }
        });
        checkBoxtwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {   checkBoxone.setChecked(false);
                    checkBoxthree.setChecked(false);
                }
            }
        });

        checkBoxthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {   checkBoxtwo.setChecked(false);
                    checkBoxone.setChecked(false);
                }
            }
        });

    }
private  void batcheckBox(){
        checkBoxone.setEnabled(true);
        checkBoxtwo.setEnabled(true);
        checkBoxthree.setEnabled(true);

}

private  void tatcheckBox(){
    checkBoxone.setEnabled(false);
    checkBoxtwo.setEnabled(false);
    checkBoxthree.setEnabled(false);
    }
}