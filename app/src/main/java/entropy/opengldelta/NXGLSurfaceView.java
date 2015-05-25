package entropy.opengldelta;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by trentonknight on 5/24/15.
 */
public class NXGLSurfaceView extends GLSurfaceView{

    public NXGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        //getContext from Render
        NXRenderer mRenderer = new NXRenderer(getContext());
        setRenderer(mRenderer);
    }


}
