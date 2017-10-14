package id.sch.smktelkom_mlg.learning.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition TRENGGALEK = CameraPosition.builder()
            .target(new LatLng(-8.0764, 111.70641)).zoom(10)
            .bearing(0).tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    MarkerOptions Tugu;
    MarkerOptions Trenggalek;
    MarkerOptions Karangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Trenggalek = new MarkerOptions()
                .position(new LatLng(-8.0764, 111.70641))
                .title("Trenggalek");

        Tugu = new MarkerOptions()
                .position(new LatLng(-8.021430, 11.603434))
                .title("Tugu");

        Karangan = new MarkerOptions()
                .position(new LatLng(-8.078581, 111.674157))
                .title("Karangan");

//        Button btnMap = (Button) findViewById(R.id.btnMap);
//        btnMap.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (mapReady) m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//            }
//        });
//
//        Button btnSatelite = (Button) findViewById(R.id.btnSatelite);
//        btnSatelite.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (mapReady) m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//            }
//        });
//
//        Button btnHybrid = (Button) findViewById(R.id.btnHybrid);
//        btnHybrid.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (mapReady) m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//            }
//        });
//
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;
        m_map.addMarker(Tugu);
        m_map.addMarker(Trenggalek);
        m_map.addMarker(Karangan);
        flyTo(TRENGGALEK);
//        LatLng eaciit = new LatLng(-7.284790, 112.736989);
//        CameraPosition target = CameraPosition.builder().target(eaciit).zoom(14).build();
//        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
