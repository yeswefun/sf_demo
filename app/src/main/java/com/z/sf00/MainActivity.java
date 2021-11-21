package com.z.sf00;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.z.sf00.player.ZPlayerView;

import java.io.File;

/*
$ man dlopen
$ man dlclose

adb logcat | ndk-stack -sym app/build/intermediates/cmake/debug/obj/arm64-v8a

    17. 代码结构的调整, 引入生产者与消费者模型(queue + cond + mutex)
        ZAudio
        ZPacketQueue
        ZPlayerState

    18. 使用SurfaceView播放视频数据

    19. 整合SurfaceView
        ZVideo

    20. 模板设计模式
        ZMedia

    21. 音视频同步的原理
*/
public class MainActivity extends AppCompatActivity {

    private final File mFile = new File(Environment.getExternalStorageDirectory(), "/Download/r.mp4");
    private ZPlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerView = findViewById(R.id.zplayer_view);
//        下面直接play，到了native层ANativeWindow_fromSurface返回空指针
//        playerView.play(mFile.getAbsolutePath());
    }

    private boolean isPlayed = false;

    public void handleClick(View view) {
        if (isPlayed) {
            return;
        }
        isPlayed = true;
        playerView.play(mFile.getAbsolutePath());
    }
}