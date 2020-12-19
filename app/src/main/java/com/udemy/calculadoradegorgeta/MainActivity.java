package com.udemy.calculadoradegorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valor_pagar;
    private TextView atualiza_seekbar;
    private SeekBar  seekbar;
    private EditText total_pagar_gorjeta;
    private EditText pagamento_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor_pagar      = findViewById( R.id.id_edittext_valor_conta );
        atualiza_seekbar = findViewById( R.id.id_textview_atualiza_seekbar );
        seekbar          = findViewById( R.id.id_seekBar_percentagem_gorjeta );
        total_pagar_gorjeta = findViewById( R.id.id_editext_total_pagar_valor_gorjeta );
        pagamento_total  = findViewById( R.id.id_edittext_total_pagar );

        // Escutando seekbar.
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                atualiza_seekbar.setText( progress+"%");
                double custo = Double.parseDouble( valor_pagar.getText().toString() );

                faz_os_calculos( custo, progress );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void faz_os_calculos( double custo, int percent )
    {
        double total_p_gorjeta = custo * percent / 100;
        total_pagar_gorjeta.setText( "R$ "+Double.toString( total_p_gorjeta ) );
        pagamento_total.setText( "R$ "+Double.toString( custo + total_p_gorjeta ) );
    }


}