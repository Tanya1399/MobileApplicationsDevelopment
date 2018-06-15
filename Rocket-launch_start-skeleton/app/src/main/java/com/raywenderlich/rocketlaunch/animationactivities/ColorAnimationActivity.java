package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.v4.content.ContextCompat;

import com.raywenderlich.rocketlaunch.R;

public class ColorAnimationActivity extends BaseAnimationActivity {

  @Override
  protected void onStartAnimation() {
    ObjectAnimator objectAnimator = ObjectAnimator.ofObject(mFrameLayout,"backgroundColor", new ArgbEvaluator(),
            ContextCompat.getColor(this, R.color.background_from),
            ContextCompat.getColor(this, R.color.background_to));
//mFrameLayout - анимируемый объект
    //"backgroundColor  - анимируемое свойтсво
    //new ArgbEvalucator() - аргумент, который указывает на то, как интерполировать медлу двумя значениями цвета (A)RGB
    objectAnimator.setRepeatCount(1);//кол-во повторений
    objectAnimator.setRepeatMode(ValueAnimator.REVERSE);//что делаем анимация вконце
//reverse - вернется в начальное положение обратно
    objectAnimator.setDuration(DEFAULT_ANIMATION_DURATION);//продолжительность
    objectAnimator.start();
  }
}
