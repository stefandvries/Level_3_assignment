package nl.stefandv.level_3_assignment;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nl.stefandv.level_3_assignment.StudentPortal.*;

public class AddPortal extends AppCompatActivity {


    static String title;
    static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        Button addPortalButton = (Button) findViewById(R.id.addPortalButton1);
        final EditText titleEditText = (EditText) findViewById(R.id.titleInput);
        final EditText urlEditText = (EditText) findViewById(R.id.urlInput);


        addPortalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                title = titleEditText.getText().toString();
                url = urlEditText.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("url", url);
                returnIntent.putExtra("title", title);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();

            }


        });

    }
}



