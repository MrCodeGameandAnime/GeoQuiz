package com.example.geoquiz

import android.util.Log
import android.widget.Button

class ChinaDynasty {
    private lateinit var someId: Button
    var name: String = "Cao Cao"
    var born: String ="155 AD"
    var died: String = "220 AD"
    var dynasty: String = "Eastern Han"

    fun getWarlordInfo(): ChinaDynasty {

        val chinaDynasty = ChinaDynasty()
        val warlord = ChinaDynasty()
        warlord.name = chinaDynasty.name
        warlord.born = chinaDynasty.born
        warlord.died = chinaDynasty.born
        warlord.dynasty = chinaDynasty.dynasty
        Log.d("WL", "getWarlordInfo: "+ warlord.name +" of the "+ warlord.dynasty +" was born in "+warlord.born+ " and died on " +warlord.died)
        return warlord

    }
}