package com.example.jorge.ejerciciovideoturismo;

import android.app.Activity;
import android.database.Cursor;
import android.media.session.MediaController;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Jorge on 22/07/2015.
 */
public class Video extends Activity {

    private UriDePeliculas dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rep_video);
        //Tramos el ID del item seleccionado
        int id = getIntent().getIntExtra("id", 0);
        dataSource = new UriDePeliculas(this);



        VideoView videoView = (VideoView)findViewById(R.id.repVideo);

        videoView.setMediaController(new android.widget.MediaController(this));



        //Checamos que ID trae el item que selecionaron
        switch (id){
            case 0:
                videoView.setVideoPath(dataSource.getIdUri(id+1 ));
                videoView.start();
                break;
            case 1:
                videoView.setVideoPath(dataSource.getIdUri(id+1 ));
                videoView.start();
                break;
            case 2:
                videoView.setVideoPath(dataSource.getIdUri(id+1 ));
                videoView.start();
                break;
            default:
                Toast toast = Toast.makeText(Video.this, "No existe el video que seleccionaste", Toast.LENGTH_LONG);
                toast.show();
                break;
        }


    /*    if (id == 0){
            videoView.setVideoPath(dataSource.getIdUri(id+1 ));
                    videoView.start();
        }else if (id == 1){
            videoView.setVideoPath(dataSource.getIdUri(id+1 ));
            videoView.start();
        }else {
            videoView.setVideoPath(dataSource.getIdUri(id+1 ));
            videoView.start();
        }
*/



    }
}
