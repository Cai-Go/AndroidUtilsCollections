# Android 工具栏集合
## [StatusBarUtil 状态栏工具类（实现沉浸式状态栏/变色状态栏）](https://jaeger.itscoder.com/android/2016/03/27/statusbar-util.html)
### StatusBarUtil 的使用
1. 设置状态栏颜色
````java
	StatusBarUtil.setColor(Activity activity, int color)
````

2. 设置状态栏半透明
````java
	StatusBarUtil.setTranslucent(Activity activity, int statusBarAlpha)
````

3. 设置状态栏全透明
````java
	StatusBarUtil.setTransparent(Activity activity)
````

4. 为包含 DrawerLayout 的界面设置状态栏颜色（也可以设置半透明和全透明）
````java
	StatusBarUtil.setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color)
````

5. 为使用 ImageView 作为头部的界面设置状态栏透明
````java
	StatusBarUtil.setTranslucentForImageView(Activity activity, int statusBarAlpha, View needOffsetView)
````

## [KLog](https://github.com/ZhaoKaiQiang/KLog)
### KLog 的使用
首先在 xxApplication 中初始化
````java
	KLog.init(BuildConfig.LOG_DEBUG, "Kai");
````