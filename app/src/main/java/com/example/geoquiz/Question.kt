package com.example.geoquiz

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean, var answered: Boolean = false) {
}
// data keyword comes with methods such as equals(), hashCode(), and toString()
// @StringRes annotation is not required but useful for Lint to provide a valid string res and
// prevent crashes when the constructor is used with an invalid res (pointing to something other than a string)