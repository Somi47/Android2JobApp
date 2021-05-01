package com.example.android2jobapp

import android.app.Activity

val Activity.injector: Android2JobAppComponent
    get() {
        return (this.applicationContext as Android2JobApp).injector
    }