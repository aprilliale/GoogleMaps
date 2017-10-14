package id.sch.smktelkom_mlg.learning.map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;


public class MainActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
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
//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(-8.046004, 111.657817));
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        streetViewPanorama.animateTo(camera, 10000);
    }
}
