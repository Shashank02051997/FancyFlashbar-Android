
# Fancy Flashbar

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html) 
[![](https://jitpack.io/v/Shashank02051997/FancyFlashbar-Android.svg)](https://jitpack.io/#Shashank02051997/FancyFlashbar-Android)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-FancyFlashbar--Android-green.svg?style=flat )]( https://android-arsenal.com/details/1/7108 )
 [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=21)

Make your native Snackbar Fancy. A library that takes the standard Snackbar to the next level with a variety of styling options. A highly customizable, powerful and easy-to-use alerting library for Android. This library allows you to show messages or alerts in your app quickly and easily.

This library allows you to show messages or alerts in your app **quickly and easily**. It can be used as an alternative to `Snackbar` or `Toast` and offers a plethora of useful features and customization options for you to play with.

It has been written **100% in Kotlin**. ❤️

![](/raw/banner.png)

# Table of Contents
* [Prerequisites](#prerequisites)
* [Usage](#usage)
    * [Basics](#basics)
    * [Gravity](#gravity)
    * [Title](#title)
    * [Message](#message)
    * [Overlay](#overlay)
    * [Positive/Negative](#positivenegative)
    * [Icon](#icon)
    * [Animations](#animations)
      * [Enter/Exit](#enterexit)
      * [Icon](#icon)
    * [Event Listeners](#event-listeners)
      * [Show](#show)
      * [Dismiss](#dismiss)
      * [Taps](#taps)
    * [Miscellaneous](#miscellaneous)
      * [Swipe-to-dismiss](#swipe-to-dismiss)
      * [Vibration](#vibration)
* [Contribution](#contribution)
* [License](#license)


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.Shashank02051997:FancyFlashbar-Android:1.1'
}
```


# Usage
It is recommended to check the sample project to get a complete understanding of all the features offered by the library.

The library offers a huge amount of customization options and leverages the `Builder` pattern for ease of use. You will find details of each of these features described below.

## Basics

<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_1.png">

Flashbar attaches a full-height, full-width view (`FlashbarContainerView`) to the decor view of the `Activity` and places a full width, dynamic height view(`FlashbarView`) inside it. These classes are internal classes and are not exposed for public use.

Here's an example of showing a basic flashbar,

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .message("Congratulations! You have reached 5K points")
        .build();
```

 You can specify the duration (in millis) for which you want the flashbar to be displayed. The default duration is infinite, i.e. it won't dismiss automatically if you do not specify any duration. You can also use these constants, `DURATION_SHORT` or `DURATION_LONG` for convenience.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .duration(500)
        .message("This is a flashbar with duration")
        .build();
```

## Gravity
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_2.png">

You can show the flashbar either at the top or at the bottom of the screen using the gravity property. By default, it is shown at the bottom.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message("Nice work! You've successfully done something that makes you great.")
        .build();
```
Or,

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .message("Flashbar is shown at the bottom")
        .build();
```

## Title
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_3.png">

You can show an optional title in the flashbar. You can also customize the color, size, typeface and appearance of it.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Success!")
        .message("Daily whatsapp status updated successfully")
        .build();
```

You can change the color using `titleColor()`, size using `titleSizeInSp()`, `titleSizeInPx()`, typeface using `titleTypeface()` and appearance using `titleAppearance()`. Also, look out for other variants of this methods.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Success!")
        .message("Daily whatsapp status updated successfully")
        .titleColorRes(R.color.white)
        .titleSizeInSp(12f)
        .titleAppearance(R.style.CustomTextStyle)
        .titleTypeface(Typeface.createFromAsset(getAssets(), "ShineBright.ttf"))
        .build();
```

## Message
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_4.png">

You can show an optional message in the flashbar. You can also customize the color, size and appearance of it.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Hello World!")
	.message("This is a short message. But your message can be of any length and the view will dynamically adjust itself.")
        .build();
```

You can change the color using `messageColor()`, size using `messageSizeInSp()`, `messageSizeInPx()`, typeface using `messageTypeface()` and appearance using `messageAppearance()`. Also, look out for other variants of this methods.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message("This is a short message")
        .messageColor(ContextCompat.getColor(this, R.color.white))
        .messageSizeInSp(16f)
        .messageTypeface(Typeface.createFromAsset(assets, "BeautifulAndOpenHearted.ttf"))
        .build();
```

## Overlay

<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_5.png">

The overlay creates a dim effect over the entire screen bringing more focus on the flashbar and its content. It is automatically added/removed along with the flashbar.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Notifications aren't allowed")
        .message("To get notification about added transcations, you need to allow them in the settings.")
        .showOverlay()
        .build();
```
You can also customize the overlay color using `overlayColor()` and also make the overlay block any click/touch events using `overlayBlockable()`.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Hello World!")
        .message("You can show a modal overlay to give a dim effect in the entire screen.")
        .showOverlay()
        .overlayColorRes(R.color.modal)
        .overlayBlockable()
        .build();
```

## Actions
There are two types of action buttons available - positive and negative (placed at the bottom).

<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_7.png">

You can also customize its appearance in a lot of ways,

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Alisa Williams")
        .message("Yeah, i'm up to it! Wanna grab something to eat today or you're bu...")
        .primaryActionText("Reply")
        .primaryActionTextColorRes(R.color.colorAccent)
        .build();
```

You can also listen to its tap/click events through the `OnActionTapListener`,

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Alisa Williams")
        .message("Yeah, i'm up to it! Wanna grab something to eat today or you're bu...")
        .primaryActionText("Reply")
        .primaryActionTextSizeInSp(20f)
        .primaryActionTextColorRes(R.color.colorAccent)
        .primaryActionTapListener(object : Flashbar.OnActionTapListener {
            override fun onActionTapped(bar: Flashbar) {
                bar.dismiss()
            }
        })
        .build();
```

### Positive/Negative
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_12.png">

You can customize the positive and negative buttons in the same way as the primary button. These buttons appear at the bottom part of the view. You can show the positive, or negative or both the buttons. You can also listen to the tap events in the same way as before.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Can we notify you ?")
        .message("Please allow us to send you notification")
	.icon(R.drawable.email)
	.showIcon()
        .positiveActionText("Allow")
        .negativeActionText("No, other time")
        .positiveActionTapListener(object : Flashbar.OnActionTapListener {
            override fun onActionTapped(bar: Flashbar) {
                bar.dismiss()
            }
        })
        .negativeActionTapListener(object : Flashbar.OnActionTapListener {
            override fun onActionTapped(bar: Flashbar) {
                bar.dismiss()
            }
        })
        .build();
```

### Icon
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/Screenshot/Fancy_Flashbar_Image_9.png">

You can show an icon on the left side of the view using `showIcon()` which will show the default icon.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Congratulations!")
        .message("Congratulations! You have reached 5K points")
        .icon(R.drawable.trophy)        
        .showIcon()
	.enableSwipeToDismiss()      //By default this feature is disabled
        .build();
```

## Animations

You can customize the enter/exit animation of the flashbar. You can also add custom animations to the icon for drawing attention towards it. The library provides a fluent API-styled animation framework to customize these animations.

### Enter/Exit
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/GIF/20180825_222232.gif" height="420" width="240">

You can start animating the bar using `FlashAnim.with(this).animateBar()`. You can change the duration of the animation using `duration()`, apply custom interpolators using `interpolator()` or choose from a set of interpolators available, add alpha transition using `alpha()`, etc.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Stay up-to-date!")
        .message("This way, you and your friends will see messages instantly on your phones.")
	.enableSwipeToDismiss()         //By default this feature is disabled	
        .icon(R.drawable.notification)
	.showIcon()
	.positiveActionText("Enable Notification")
        .negativeActionText("Not Now")
        .positiveActionTapListener(new Flashbar.OnActionTapListener() {
                    @Override
                    public void onActionTapped(@NotNull Flashbar bar) {
                        bar.dismiss();
                    }
                })
        .negativeActionTapListener(new Flashbar.OnActionTapListener() {
                    @Override
                    public void onActionTapped(@NotNull Flashbar bar) {
                        bar.dismiss();
                    }
                })
                
        .enterAnimation(FlashAnim.with(this)
                .animateBar()
                .duration(750)
                .alpha()
                .overshoot())
        .exitAnimation(FlashAnim.with(this)
                .animateBar()
                .duration(400)
                .accelerateDecelerate())
        .build();
```


**Note** - You can configure the animations with your desired specifications in the builder and pass it on. You can not call `build()` on these animations as it is reserved to be used internally from inside the library only.

### Icon
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/GIF/20180825_221820.gif" height="420" width="240">

You can start animating the icon using `FlashAnim.with(this).animateIcon()`. You can change the duration of the animation using `duration()`, apply custom interpolators using `interpolator()` or choose from a set of interpolators available, add pulsating effect using `pulse()` and alpha transition using `alpha()`, etc.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Alisha liked your Tweet")
        .message("THE BIGGEST RISK IS NOT TAKING THE RISK")
        .showIcon()
        .icon(R.drawable.heart)
        .iconAnimation(FlashAnim.with(this)
                .animateIcon()
                .pulse()
                .alpha()
                .duration(750)
                .accelerate())
        .build();
```

## Event Listeners
You can listen to events like when the flashbar is showing, or dismissing. You can also listen to progress updates when the flashbar is being shown or dismissed to perform animations on other views if needed.

You can also listen to tap events inside or outside the bar.

### Show
You can listen to events on `OnBarShowListener` like `onShowing`, `onShowProgress` and `onShown`. The progress ranges from from 0.0 to 1.0. But in some special cases (like with bounce interpolator) it can go below 0.0 or above 1.0.
 
```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Hello World!")
        .message("You can listen to events when the flashbar is shown")
        .barShowListener(object : Flashbar.OnBarShowListener {
            override fun onShowing(bar: Flashbar) {
                Log.d(TAG, "Flashbar is showing")
            }

            override fun onShowProgress(bar: Flashbar, progress: Float) {
                Log.d(TAG, "Flashbar is showing with progress: $progress")
            }

            override fun onShown(bar: Flashbar) {
                Log.d(TAG, "Flashbar is shown")
            }
        })
        .build();
```
### Dismiss
You can listen to events on `OnBarDismissListener` like `onDismissing`, `onDismissProgress` and `onDismissed`. The progress ranges from from 0.0 to 1.0. But in some special cases (like with bounce interpolator) it can go below 0.0 or above 1.0. 

You can also specifically get to know the reason behind the bar dismiss action - `TIMEOUT`, `MANUAL`, `TAP_OUTSIDE` and `SWIPE`.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Hello World!")
        .duration(500)
        .message("You can listen to events when the flashbar is dismissed")
        .barDismissListener(object : Flashbar.OnBarDismissListener {
            override fun onDismissing(bar: Flashbar, isSwiped: Boolean) {
                Log.d(TAG, "Flashbar is dismissing with $isSwiped")
            }

            override fun onDismissProgress(bar: Flashbar, progress: Float) {
                Log.d(TAG, "Flashbar is dismissing with progress $progress")
            }

            override fun onDismissed(bar: Flashbar, event: Flashbar.DismissEvent) {
                Log.d(TAG, "Flashbar is dismissed with event $event")
            }
        })
        .build();
```

### Taps
You can listen to tap events inside or outside of the bar.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Hello World!")
        .message("You can listen to tap events inside or outside te bar.")
        .listenBarTaps(object : Flashbar.OnTapListener {
            override fun onTap(flashbar: Flashbar) {
                Log.d(TAG, "Bar tapped")
            }
        })
        .listenOutsideTaps(object : Flashbar.OnTapListener {
            override fun onTap(flashbar: Flashbar) {
                Log.d(TAG, "Outside tapped")
            }
        })
        .build();
```

## Miscellaneous
A quick look at some of the miscellaneous features available in flashbar.

### Swipe-to-dismiss
<img src="https://github.com/Shashank02051997/FancyFlashbar-Android/blob/master/FancyFlashbar%20Screenshots/GIF/20180825_222232.gif" height="420" width="240">

You can enable this feature to dismiss the flashbar by swiping it left/right. By default this feature is disabled. You can also know if the bar was dismissed by a swipe from the `DismissEvent` as `SWIPE`.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Hello World!")
        .message("You can swipe the flasbar to dismiss it.")
        .enableSwipeToDismiss()
        .build(); 
```

### Vibration
The flashbar can produce a short vibration to seek the attention of the user when it is shown, dismissed or both.

```kotlin
new Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.BOTTOM)
        .title("Hello World!")
        .message("You can swipe the flashbar to dismiss it.")
        .vibrateOn(Flashbar.Vibration.SHOW, Flashbar.Vibration.DISMISS)
        .build();
```


## Dependencies

This project use this libraries ~ Thanks to them.

  [ZigzagView](https://github.com/beigirad/ZigzagView)

## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/Shashank02051997/FancyFlashbar-Android/pulls).

# Contribution

I highly encourage the community to step forward and improve this library further. You can fix any reported bug, propose or implement new features, write tests, etc.

Here is a quick list of things to remember -
* Check the open issues before creating a new one,
* Help me in reducing the number of open issues by fixing any existing bugs,
* Check the roadmap to see if you can help in implementing any new feature,
* You can contribute by writing unit and integration tests for this library,
* If you have any new idea that aligns with the goal of this library, feel free to raise a feature request and discuss it.


## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/Shashank02051997/FancyToast-Android/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

### Contact - Let's become friend
- [Twitter](https://twitter.com/shashank020597)
- [Github](https://github.com/Shashank02051997)
- [Linkedin](https://www.linkedin.com/in/shashank-singhal-a87729b5/)
- [Facebook](https://www.facebook.com/shashanksinghal02)

## Donation
If this project help you reduce time to develop, you can give me a cup of coffee :) 

<a href="https://www.buymeacoffee.com/mXUuDW7" target="_blank"><img src="https://bmc-cdn.nyc3.digitaloceanspaces.com/BMC-button-images/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

# License

```
Copyright 2018 Shashank Singhal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
