package com.shashank.platform.fancyflashbarlibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView.ScaleType;

import com.shashank.platform.fancyflashbarlib.Flashbar;
import com.shashank.platform.fancyflashbarlib.anim.FlashAnim;

import org.jetbrains.annotations.NotNull;

public class JavaSampleActivity extends AppCompatActivity {

    private static final String TAG = "Flashbar";

    private Flashbar flashbar = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show = findViewById(R.id.show);
        Button dismiss = findViewById(R.id.dismiss);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flashbar == null) {
                    flashbar = fancyFlashbar();
                }
                flashbar.show();
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flashbar != null) {
                    flashbar.dismiss();
                    flashbar = null;
                }
            }
        });
    }

    private Flashbar fancyFlashbar() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .enableSwipeToDismiss() //By default this feature is disabled
                .icon(R.drawable.email)
                .title("Can we notify you ?")
                .message("Please allow us to send you notification")
                .showIcon()
                .positiveActionText("Allow")
                .negativeActionText("No, other time")
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
                        .duration(550)
                        .alpha()
                        .overshoot())
                .exitAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(500)
                        .alpha()
                        .overshoot())
                .duration(3000)
                //.vibrateOn(Flashbar.Vibration.SHOW, Flashbar.Vibration.DISMISS)
                //.showOverlay()
                //.titleColorRes(R.color.white)
                //.titleSizeInSp(28)
                //.titleTypeface(Typeface.createFromAsset(getAssets(), "BeautifulAndOpenHearted.ttf"))
                //.messageColor(ContextCompat.getColor(this, R.color.white))
                //.messageSizeInSp(24)
                //.messageTypeface(Typeface.createFromAsset(getAssets(), "BeautifulAndOpenHearted.ttf"))
                //.overlayColorRes(R.color.modal)
                //.positiveActionTextColorRes(R.color.black)
                //.negativeActionTextColorRes(R.color.yellow)
                /*.iconAnimation(FlashAnim.with(this)
                        .animateIcon()
                        .pulse()
                        .alpha()
                        .duration(750)
                        .accelerate())*/
                /*.enterAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(400)
                        .slideFromLeft()
                        .overshoot())
                .exitAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(250)
                        .slideFromLeft()
                        .accelerate())*/
                .build();
    }


    private Flashbar showListener() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .title("Hello World!")
                .message("You can listen to events when the flashbar is shown.")
                .barShowListener(new Flashbar.OnBarShowListener() {
                    @Override
                    public void onShowing(@NotNull Flashbar bar) {
                        Log.d(TAG, "Flashbar is showing");
                    }

                    @Override
                    public void onShowProgress(@NotNull Flashbar bar, float progress) {
                        Log.d(TAG, "Flashbar is showing with progress: " + progress);
                    }

                    @Override
                    public void onShown(@NotNull Flashbar bar) {
                        Log.d(TAG, "Flashbar is shown");
                    }
                })
                .build();
    }

    private Flashbar dismissListener() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .title("Hello World!")
                .duration(500)
                .message("You can listen to events when the flashbar is dismissed.")
                .barDismissListener(new Flashbar.OnBarDismissListener() {
                    @Override
                    public void onDismissing(@NotNull Flashbar bar, boolean isSwiped) {
                        Log.d(TAG, "Flashbar is dismissing with " + isSwiped);
                    }

                    @Override
                    public void onDismissProgress(@NotNull Flashbar bar, float progress) {
                        Log.d(TAG, "Flashbar is dismissing with progress " + progress);
                    }

                    @Override
                    public void onDismissed(@NotNull Flashbar bar,
                            @NotNull Flashbar.DismissEvent event) {
                        Log.d(TAG, "Flashbar is dismissed with event " + event);
                    }
                })
                .build();
    }

    private Flashbar barTap() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.TOP)
                .title("Hello World!")
                .message("You can listen to tap events inside or outside te bar.")
                .listenBarTaps(new Flashbar.OnTapListener() {
                    @Override
                    public void onTap(@NotNull Flashbar flashbar) {
                        Log.d(TAG, "Bar tapped");
                    }
                })
                .listenOutsideTaps(new Flashbar.OnTapListener() {
                    @Override
                    public void onTap(@NotNull Flashbar flashbar) {
                        Log.d(TAG, "Outside tapped");
                    }
                })
                .build();
    }



}