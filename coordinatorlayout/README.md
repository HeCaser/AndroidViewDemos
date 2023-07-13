
2023-07-13

# AppBarLayout 使用

CoordinatorLayout 中使用 AppBarLayout

- AppBarLayout 是一个纵向布局的 LinearLayout, 其包含的 Views 会在 CoordinatorLayout 顶部

- 配合 AppBarLayout 使用的 View,要求具备纵向滚动能力,并配置 `layout_behavior`

```
   <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layout_behavior="@string/appbar_scrolling_view_behavior">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="标题头 " />

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/rv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </LinearLayout>
    
```

- `AppBarLayout` 子 View 滚动交互由 `layout_scrollFlags` 设置

```
 <TextView
    android:layout_width="match_parent"
    android:layout_height="140dp"
    android:background="@color/cardview_dark_background"
    android:gravity="center_vertical"
    android:paddingLeft="16dp"
    android:text="AppBarLayout scroll 模式"
    app:layout_scrollFlags="scroll" />
```
[scroll 模式交互](img/scroll.mp4)

- 向上滑动时, AppBar 逐渐隐藏, AppBar 全部隐藏后,展示包含纵向滚动 View 的部分
- 向下滚动是, 纵向滚动 View 先消费滚动事件, 当其不能再下滑时, AppBar 逐渐出现

[scroll|enterAlways 模式交互](img/scroll-enterAlways.mov)

- 向上滑动和 scroll 一样
- 向下滑动时,优先展示 AppBar,AppBar 完全展示后, 纵向滑动控件再消费滑动事件

-- 其他模式

- 
  