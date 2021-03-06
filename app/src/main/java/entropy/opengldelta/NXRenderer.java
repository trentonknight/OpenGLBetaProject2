package entropy.opengldelta;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by trentonknight on 5/24/15.
 */
public class NXRenderer implements Renderer{

    private final Context context;
    private Triangle mTriangle;

   // private Context mContext;



    public NXRenderer(Context context) {
        //Create context for pass to SurfaceView
        this.context = context;
        String vertexSource = ShaderManager.readText(context, R.raw.vertexone);
        String fragSource = ShaderManager.readText(context, R.raw.fragmentone);
    }

    public void onDrawFrame(GL10 unused) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        mTriangle.draw();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        mTriangle = new Triangle();

    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

}
