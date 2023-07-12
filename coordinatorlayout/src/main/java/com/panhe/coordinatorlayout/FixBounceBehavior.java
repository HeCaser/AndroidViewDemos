package com.panhe.coordinatorlayout;

import static android.view.MotionEvent.ACTION_DOWN;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;

import java.lang.reflect.Field;

public class FixBounceBehavior extends AppBarLayout.Behavior {

    public FixBounceBehavior() {
        super();
    }

    public FixBounceBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        stopAppbarLayoutFling(child);
        return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
        if (type == ViewCompat.TYPE_NON_TOUCH) {
            //当target滚动到边界时主动停止target fling,与下一次滑动产生冲突
            if (getTopAndBottomOffset() == 0) {
                ViewCompat.stopNestedScroll(target, type);
            }
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, AppBarLayout child, MotionEvent ev) {
        if (ev.getAction() == ACTION_DOWN) {
            stopAppbarLayoutFling(child);
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    /**
     * 反射获取私有的flingRunnable 属性，考虑support 28以后变量名修改的问题
     *
     * @return Field
     */
    private Field getFlingRunnableField() {
        Class<?> superclass = this.getClass().getSuperclass();
        Field field = null;
        try {
            // 可能是28及以上版本
            Class<?> headerBehaviorType = superclass.getSuperclass().getSuperclass();
            if (headerBehaviorType != null) {
                field = headerBehaviorType.getDeclaredField("flingRunnable");
                field.setAccessible(true);
            }
        } catch (Exception e) {

        }
        if (field == null) {
            try {
                // support design 27及一下版本
                Class<?> headerBehaviorType = superclass.getSuperclass();
                if (headerBehaviorType != null) {
                    field = headerBehaviorType.getDeclaredField("mFlingRunnable");
                    field.setAccessible(true);
                }
            } catch (Exception e) {

            }
        }
        return field;
    }

    /**
     * 反射获取私有的scroller 属性，考虑support 28以后变量名修改的问题
     *
     * @return Field
     */
    private Field getScrollerField() {
        Class<?> superclass = this.getClass().getSuperclass();
        Field field = null;
        try {
            // 可能是28及以上版本
            Class<?> headerBehaviorType = superclass.getSuperclass().getSuperclass();
            if (headerBehaviorType != null) {
                field = headerBehaviorType.getDeclaredField("scroller");
                field.setAccessible(true);
            }
        } catch (Exception e) {

        }
        if (field == null) {
            try {
                // support design 27及一下版本
                Class<?> headerBehaviorType = superclass.getSuperclass();
                if (headerBehaviorType != null) {
                    field = headerBehaviorType.getDeclaredField("mScroller");
                    field.setAccessible(true);
                }
            } catch (NoSuchFieldException e) {

            }
        }
        return field;
    }

    /**
     * 停止appbarLayout的fling事件
     *
     * @param appBarLayout
     */
    private void stopAppbarLayoutFling(AppBarLayout appBarLayout) {
        //通过反射拿到HeaderBehavior中的flingRunnable变量
        try {
            Field flingRunnableField = getFlingRunnableField();
            Runnable flingRunnable;
            if (flingRunnableField != null) {
                flingRunnableField.setAccessible(true);
                flingRunnable = (Runnable) flingRunnableField.get(this);
                if (flingRunnable != null) {
                    appBarLayout.removeCallbacks(flingRunnable);
                    flingRunnableField.set(this, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Field scrollerField = getScrollerField();
            if (scrollerField != null) {
                scrollerField.setAccessible(true);
                OverScroller overScroller = (OverScroller) scrollerField.get(this);
                if (overScroller != null && !overScroller.isFinished()) {
                    overScroller.abortAnimation();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
