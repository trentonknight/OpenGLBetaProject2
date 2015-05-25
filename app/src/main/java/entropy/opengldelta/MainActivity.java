package entropy.opengldelta;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;


public class MainActivity extends Activity {

    private GLSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLView = new NXGLSurfaceView(this);
        setContentView(mGLView);
    }
    @Override
    protected void onPause(){
        super.onPause();
        mGLView.onPause();
    }

    @Override
    protected  void onResume(){
        super.onResume();
        mGLView.onResume();
    }
}
