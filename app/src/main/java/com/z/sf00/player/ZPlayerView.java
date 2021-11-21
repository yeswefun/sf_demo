package com.z.sf00.player;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;

public class ZPlayerView extends SurfaceView {

    static {
        System.loadLibrary("native-lib");
    }

    public ZPlayerView(Context context) {
        this(context, null);
    }

    public ZPlayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZPlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getHolder().setFormat(PixelFormat.RGBA_8888);
    }

    public void play(String url) {
        nPlay(getHolder().getSurface(), url);
    }

    private native void nPlay(Surface surface, String url);
}
