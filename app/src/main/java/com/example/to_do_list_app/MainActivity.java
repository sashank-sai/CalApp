package com.example.to_do_list_app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        add=findViewById(R.id.add);
        layout=findViewById(R.id.container);

        buildDialog();

        add.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                    dialog.show();
            }
        });

        }

        public void buildDialog(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);
            @SuppressLint({"LocalSuppress", "MissingInflatedId"})
         final EditText name =view.findViewById(R.id.nameEdit);

            builder.setView(view);
            builder.setTitle("enter your task")
                    .setPositiveButton("SAVE",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick (DialogInterface dialog,int which){
                            addCard(name.getText().toString());
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

            dialog =builder.create();


    }
    private void addCard(String name){
        final View view =getLayoutInflater().inflate(R.layout.crad,null);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView nameview =view.findViewById(R.id.name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button delete =view.findViewById(R.id.delete);
        nameview.setText((name));
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                layout.removeView(view);

            }

        });
        layout.addView(view);
    }
}