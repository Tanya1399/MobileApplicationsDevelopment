package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class AccelerateRocketAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);//метод ofFloat принимает 2 числа ( 0 (низ экрана) -mScreenHeight - отрицание высоты экрана) - снизу вверх

    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();

        mRocket.setTranslationY(value);
      }
    });
    valueAnimator.setInterpolator(new AccelerateInterpolator(1.5f));//ускорение ракеты
    valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);

    valueAnimator.start();
  }
}
