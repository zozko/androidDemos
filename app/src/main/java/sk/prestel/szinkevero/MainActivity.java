package sk.prestel.szinkevero;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button b_red;
    private Button b_green;
    private Button b_blue;
    private Szinek sz;
    private TextView szintarto;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_red = new Button(this);
        b_green = new Button(this);
        b_blue = new Button(this);

        sz = new Szinek(115, 194, 251);
        szintarto = (TextView) findViewById(R.id.tv_szintarto);
        szinvaltoztato();
        b_red = (Button) findViewById(R.id.btn_red);
        b_green = (Button) findViewById(R.id.btn_green);
        b_blue = (Button) findViewById(R.id.btn_blue);
        b_red.setBackgroundColor(Color.rgb(sz.getRed(), 0, 0));
        b_green.setBackgroundColor(Color.rgb(0, sz.getGreen(), 0));
        b_blue.setBackgroundColor(Color.rgb(0, 0, sz.getBlue()));

        label(sz.getRed(), sz.getGreen(), sz.getBlue());
//red

        b_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sz.getRed()>=255) {
                    sz.setRed(-1);
                }
                    sz.setRed(sz.getRed() + 1);
                b_red.setBackgroundColor(Color.rgb(sz.getRed(), 0, 0));
                label(sz.getRed(), sz.getGreen(), sz.getBlue());
                szinvaltoztato();
            }
        });
//green

        b_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sz.getGreen()>=255) {
                    sz.setGreen(-1);
                }
                sz.setGreen(sz.getGreen() + 1);
                b_green.setBackgroundColor(Color.rgb(0, sz.getGreen(), 0));
                label(sz.getRed(), sz.getGreen(), sz.getBlue());
                szinvaltoztato();
            }
        });

        //blue

        b_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sz.getBlue()>=255) {
                    sz.setBlue(-1);
                }
                sz.setBlue(sz.getBlue() + 1);
                b_blue.setBackgroundColor(Color.rgb(0, 0, sz.getBlue()));
                label(sz.getRed(), sz.getGreen(), sz.getBlue());
                szinvaltoztato();
            }
        });
    }

    public void label(int red, int green, int blue) {
        TextView labelRed = (TextView) findViewById(R.id.tv_red);
        TextView labelGreen = (TextView) findViewById(R.id.tv_green);
        TextView labelBlue = (TextView) findViewById(R.id.tv_blue);

        labelRed.setText(red + "");
        labelGreen.setText(green + "");
        labelBlue.setText(blue + "");
    }

    public void szinvaltoztato() {
        szintarto.setBackgroundColor(Color.rgb(sz.getRed(), sz.getGreen(), sz.getBlue()));
    }
}
