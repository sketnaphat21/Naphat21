/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.textswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * This sample shows the use of the {@link android.widget.TextSwitcher} View with animations. A
 * {@link android.widget.TextSwitcher} is a special type of {@link android.widget.ViewSwitcher} that animates
 * the current text out and new text in when
 * {@link android.widget.TextSwitcher#setText(CharSequence)} is called.
 */
public class MainActivity extends Activity {
    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        // Get the TextSwitcher view from the layout
        mSwitcher = findViewById(R.id.switcher);

        // BEGIN_INCLUDE(setup)
        // Set the factory used to create TextViews to switch between.
        mSwitcher.setFactory(mFactory);

        /*
         * Set the in and out animations. Using the fade_in/out animations
         * provided by the framework.
         */
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        // END_INCLUDE(setup)

        /*
         * Setup the 'next' button. The counter is incremented when clicked and
         * the new value is displayed in the TextSwitcher. The change of text is
         * automatically animated using the in/out animations set above.
         */
        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mCounter++;

                    mCounter++;

                    // BEGIN_INCLUDE(settext)
                    if (mCounter == 1) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swi);
                        mSwitcher.setText("Star Wars Episode I: The Phantom Menace");
                    } else if (mCounter == 2) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swii);
                        mSwitcher.setText("Star Wars Episode II : Attack of the Clones");
                    } else if (mCounter == 3) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swiii);
                        mSwitcher.setText("Star Wars Episode III : Revenge of the Sith");
                    } else if (mCounter == 4) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swro);
                        mSwitcher.setText("Star Wars : Rogue One");
                    } else if (mCounter == 5) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swiv);
                        mSwitcher.setText("Star Wars Episode IV : New Hope");
                    } else if (mCounter == 6) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swv);
                        mSwitcher.setText("Star Wars Episode V : Empire Strike Back");
                    } else if (mCounter == 7) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swvi);
                        mSwitcher.setText("Star Wars Episode VI : Return of the Jedi");
                    }
                    else  {
                        mCounter = 7;
                    }
                //mSwitcher.setText(String.valueOf(mCounter));
                // END_INCLUDE(settext)
            }
        });

        Button nextButton2 = findViewById(R.id.button2);
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter--;

                    if (mCounter == 1) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swi);
                        mSwitcher.setText("Star Wars Episode I: The Phantom Menace");
                    } else if (mCounter == 2) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swii);
                        mSwitcher.setText("Star Wars Episode II : Attack of the Clones");
                    } else if (mCounter == 3) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swiii);
                        mSwitcher.setText("Star Wars Episode III : Revenge of the Sith");
                    } else if (mCounter == 4) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swro);
                        mSwitcher.setText("Star Wars : Rogue One");
                    } else if (mCounter == 5) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swiv);
                        mSwitcher.setText("Star Wars Episode IV : New Hope");
                    } else if (mCounter == 6) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swv);
                        mSwitcher.setText("Star Wars Episode V : Empire Strike Back");
                    } else if (mCounter == 7) {
                        imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.swvi);
                        mSwitcher.setText("Star Wars Episode VI : Return of the Jedi");
                    }
                    else  {
                        mCounter = 1;
                    }

                //mSwitcher.setText(String.valueOf(mCounter));
                // END_INCLUDE(settext)
            }
        });
        // Set the initial text without an animation
        mSwitcher.setCurrentText("A_STAR_WARS_STORY");

    }

    // BEGIN_INCLUDE(factory)
    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    private ViewFactory mFactory = new ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
    // END_INCLUDE(factory)
}
