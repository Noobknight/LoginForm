#Login Template

A template design for login, easy make user interface and validation

Preview :

[![Build screen](https://github.com/Noobknight/LoginForm/blob/master/login_screenshot.png)]

#Download
In your module [ ![Download](https://api.bintray.com/packages/noobknight/maven/LoginForm/images/download.svg) ](https://bintray.com/noobknight/maven/LoginForm/_latestVersion)

Gradle :
```groovy
compile 'com.github.noobknight:login:1.0.0'
```
#Usage
Add Login to your activity's layout
- Default UI
```xml
<com.tadev.login.Login xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:login="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
- Customize UI
```xml
<?xml version="1.0" encoding="utf-8"?>
<com.tadev.login.Login xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:login="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    login:colorAlpha="#00000000"
    login:backgroundForm="@color/white"
    ...
    />
```
- Supported attributes  for custom view
```xml
colorBackgroundForm : change color Background
backgroundForm : change image Background
iconLogin : change logo
firstFieldName : change Hint first field
secondsFieldName : change Hint seconds field 
colorAlpha : change color transparent Background (hex 8-digital)
enable_social : enable login via Facebook or G+ (true - false) 
colorButtonLogin : change color Button Login
colorTextButton change color text Button
```
- Color Hex Transparent
```xml
100% — FF
95% — F2
90% — E6
85% — D9
80% — CC
75% — BF
70% — B3
65% — A6
60% — 99
55% — 8C
50% — 80
45% — 73
40% — 66
35% — 59
30% — 4D
25% — 40
20% — 33
15% — 26
10% — 1A
5% — 0D
0% — 00
```
- Change color Hint InputTextLayout

Change color of **colorAccent** in styles.xml
```xml
<item name="colorAccent">@color/colorPrimary</item>
```
- Default Theme :
```xml
<style name="AppBaseTheme" parent="Theme.AppCompat.Light.NoActionBar" />
    <!-- Base application theme. -->
    <style name="AppTheme" parent="AppBaseTheme">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
</style>
```
- Callback event when view click
```java
        login.setLoginListener(new Login.LoginCallBack() {
            @Override
            public void onLoginClick(View view) {
                if(view.getId() == R.id.btnLogin){
                    //Do connect what you want...
                }else if(view.getId() == R.id.btnLoginFb){
                    //Do connect with Facebook
                }else if(view.getId() == R.id.btnLoginGPlus){
                    //Do connect with Google plus
                }else if(view.getId() == R.id.txtForgetPwd){
                    //....
                }
            }
        });
```
- You can pass message to validate

![alt tag](https://github.com/Noobknight/LoginForm/blob/master/message.jpg)

- Validate with regex

```java
 public void setRegexUser(String regexUser)
 public void setRegexPwd(String regexPwd)
```
... And some properties !

#Credits
Author : Tadev

Email : cheatgame.hit@gmail.com
