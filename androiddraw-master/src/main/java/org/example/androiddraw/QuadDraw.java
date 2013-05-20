/**
 * Copyright 2012 John Ericksen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.androiddraw;

import android.view.View;
import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;

import javax.inject.Inject;

@Activity(label = "@string/app_name")
@Layout(R.layout.quad)
public class QuadDraw {

    private QuadDrawView drawView;

    @Inject
    @org.androidtransfuse.annotations.View(R.id.quaddrawview)
    public QuadDraw(QuadDrawView drawView) {
        this.drawView = drawView;
    }

    @RegisterListener(R.id.clearbutton)
    public View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawView.clear();
        }
    };

}