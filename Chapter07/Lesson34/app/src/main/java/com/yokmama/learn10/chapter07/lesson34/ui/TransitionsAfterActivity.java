package com.yokmama.learn10.chapter07.lesson34.ui;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

import com.yokmama.learn10.chapter07.lesson34.R;
import com.yokmama.learn10.chapter07.lesson34.utils.ViewUtils;

/**
 * Created by kayo on 15/04/15.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class TransitionsAfterActivity extends Activity {
    public static final String EXTRA_COLOR_ACCENT_ID = "extra.COLOR_ACCENT_ID";
    public static final String EXTRA_BACKGROUND_ID = "extra.BACKGROUND_ID";

    private Toolbar mToolbar;
    private Button mFab;
    private TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transitions_after);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFab = (Button) findViewById(R.id.action);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        // Toolbar の設定
        mToolbarTitle.setText(getTitle());
        mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 背景色
        mToolbar.setBackgroundColor(getResources().getColor(getIntent().getIntExtra(EXTRA_COLOR_ACCENT_ID, 0)));
        mFab.setBackgroundResource(getIntent().getIntExtra(EXTRA_BACKGROUND_ID, 0));

        doRevealEffect();
    }

    private void doRevealEffect() {
        // RevealEffectは、ビューのサイズが計算されたタイミング以降でしか呼び出せない
        // そのため、ビューが計算されるまで待つ
        ViewUtils.callOnLayout(mToolbar, new ViewUtils.OnLayoutCallback() {
            @Override
            public void onLayout(View v) {
                // Reveal Effect を実施
                int centerX = mToolbar.getWidth() / 2;
                int centerY = mToolbar.getHeight() / 2;
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        mToolbar,
                        centerX, centerY,
                        0,
                        (float) Math.hypot(centerX, centerY));

                // 緩急の指定
                Interpolator interpolator = AnimationUtils.loadInterpolator(getApplicationContext(),
                        android.R.interpolator.accelerate_cubic);
                animator.setInterpolator(interpolator);

                // アニメーション開始
                animator.start();
            }
        });
    }

}