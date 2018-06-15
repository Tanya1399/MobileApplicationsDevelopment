package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

public class LaunchAndSpinAnimatorSetAnimatorActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
    ValueAnimator positionAnimator = ValueAnimator.ofFloat(0,-mScreenHeight);

    positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        mRocket.setTranslationY(value);
      }
    });

    ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(mRocket,"rotation",0,180f);
    AnimatorSet animatorSet = new AnimatorSet();

    animatorSet.play(positionAnimator).with(rotationAnimator);

    animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
    animatorSet.start();

    /* Создаем новый ValueAnimator
    AnimatorUpdateListener слушатель, котрый обновляет положение ракеты
    Создается ObjectAnimtorЮ второй аниматор, который обновляет вращение ракеты
    Создается новый экземпляр AnimtorSet, который позволяет воспроизвдить несколько
    анимаций вместе
    with - для вопспроизведение аниматора переданного в качестве аргумента одновременно с перый в play()

     */
  }
}
