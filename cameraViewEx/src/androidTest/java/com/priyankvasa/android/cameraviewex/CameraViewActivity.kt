/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.priyankvasa.android.cameraviewex

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.SurfaceView
import com.priyankvasa.android.cameraviewex.test.R

class CameraViewActivity : Activity() {

    private val camera: CameraView by lazy {
        findViewById<CameraView>(R.id.camera)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_view)
    }

    override fun onResume() {
        super.onResume()
        camera.start()
    }

    override fun onPause() {
        camera.stop()
        super.onPause()
    }

    override fun onDestroy() {
        camera.destroy()
        super.onDestroy()
    }

    fun quickFrame(): Bitmap {
        val v = findViewById<SurfaceView>(R.id.save_image_matrix)
        val b = Bitmap.createBitmap(v.layoutParams.width, v.layoutParams.height, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        v.layout(0, 0, v.layoutParams.width, v.layoutParams.height)
        v.draw(c)
        return b
    }
}