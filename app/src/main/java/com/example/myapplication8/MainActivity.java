package com.example.myapplication8;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    String sp_it[]={"1학년","2학년","3학년","4학년","5학년"};
    Spinner sp;
    EditText ed1,ed2; Button b1,b2;
    CheckBox cb1,cb2,cb3;
    RadioButton r1,r2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sex
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);

        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        //hobby
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);

        sp=(Spinner)findViewById(R.id.sp);
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sp_it);
        sp.setAdapter(ad1);

        //reset button
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View view) {
                                      cb1.setChecked(false);
                                      cb2.setChecked(false);
                                      cb3.setChecked(false);
                                      r1.setChecked(false);r2.setChecked(false);
                                      ed1.setText(""); ed2.setText("");
                                      sp.setSelection(0);

                                  }

                              }

        );

        //result print
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sex
                String s1="";
                if(r1.isChecked()) s1=r1.getText().toString();
                else s1=r2.getText().toString();

                //hobby
                String s2="";
                if(cb1.isChecked())
                    s2+=cb1.getText().toString();
                if(cb2.isChecked())
                    s2+=cb2.getText().toString();
                if(cb3.isChecked())
                    s2+=cb3.getText().toString();

                //grade
                String s3=sp.getSelectedItem().toString();
                ed2.append("학년:"+s3+"\n");
                ed2.append("이름:"+ed1.getText().toString()+"\n");
                ed2.append("성별:"+s1+"\n");
                ed2.append("취미:"+s2+"\n");


            }

        });

    }

}
