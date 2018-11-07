package br.com.senaijandira.marcadordetruco;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn6,btn9,btn12;
    private TextView txtpountua;

    PontuacaoViewModel vm;//ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn6 = findViewById(R.id.btn6);
        btn9 = findViewById(R.id.btn9);
        btn12 = findViewById(R.id.btn12);

        vm = ViewModelProviders.of(this).get(PontuacaoViewModel.class);

        if(vm.pontuacao.getValue() == null){
            vm.pontuacao.setValue(0);
        }

        txtpountua = findViewById(R.id.txtPontuacao);

        vm.pontuacao.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {

                txtpountua.setText(integer.toString());
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.pontuacao.setValue(vm.pontuacao.getValue()+1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.pontuacao.setValue(vm.pontuacao.getValue()+2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.pontuacao.setValue(vm.pontuacao.getValue()+3);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.pontuacao.setValue(vm.pontuacao.getValue()+6);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.pontuacao.setValue(vm.pontuacao.getValue()+9);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.pontuacao.setValue(vm.pontuacao.getValue()+12);
            }
        });
    }



}
