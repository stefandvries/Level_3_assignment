package nl.stefandv.level_3_assignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentPortal extends AppCompatActivity {

    ArrayList<Portal> portals = new ArrayList<>();
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(StudentPortal.this, AddPortal.class);
                startActivityForResult(i, 1);

            }

        });


        recyclerView = findViewById(R.id.recyclerv_view);
        adapter = new RecyclerViewAdapter(this, portals);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void updateUI() {
        if (adapter == null) {
            adapter = new RecyclerViewAdapter(this, portals);
            recyclerView.setAdapter(adapter);
        } else {
            Log.d("hallo", "hallo");
            adapter.notifyDataSetChanged();

        }
    }


    public void addToList(String portalURL, String portalTitle) {
        portals.add(new Portal(portalURL, portalTitle));
        Toast.makeText(StudentPortal.this, "Item Added: " + portalTitle, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student_portal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String url = data.getStringExtra("url");
                String title = data.getStringExtra("title");
                Log.d("url", url);
                Log.d("title", title);

                addToList(url, title);
                updateUI();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

}
