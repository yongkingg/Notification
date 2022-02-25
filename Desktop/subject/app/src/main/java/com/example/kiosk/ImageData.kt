package com.example.kiosk


class ImageData {
    var beverageImage = mutableListOf<Int>(
        R.drawable.americano,
        R.drawable.ainsupanner,
        R.drawable.coldbrew,
        R.drawable.caffeelattee,
        R.drawable.whitebeinna,
        R.drawable.coldbrewnitro,
        R.drawable.caffeemoca,
        R.drawable.cappuccino
    )
    var iceFlakeImage = mutableListOf<Int>(
        R.drawable.pathinzulmi,
        R.drawable.mangoyogurt,
        R.drawable.mangoshabet,
        R.drawable.strawberrybingsu,
        R.drawable.pathbingsu
    )
    var newMenuImage = mutableListOf<Int>(
        R.drawable.strawberrylattee,
        R.drawable.strawberrymilkflatccino,
        R.drawable.strawberrypeach,
        R.drawable.strawberrypeachhot
    )
    var cakeImage = mutableListOf<Int>(
        R.drawable.strawberrybread,
        R.drawable.strawberrywaple,
        R.drawable.strawberrycrople,
        R.drawable.toppinutcrwople,
        R.drawable.toppinutcrwaruasang,
        R.drawable.plaincrople,
        R.drawable.plaincrwaruasang,
        R.drawable.rosie
    )

    var flatccinoImage = mutableListOf<Int>(
        R.drawable.coffeeflatccino,
        R.drawable.peachflatccino,
        R.drawable.strawberryyogurtflatccion,
        R.drawable.topinutflatccino,
        R.drawable.strawberryflatccino
    )

    var shakeAdeImage = mutableListOf<Int>(
        R.drawable.ade,
        R.drawable.jamongade,
        R.drawable.lemonade,
        R.drawable.originshake,
        R.drawable.oreoshake
    )
    var image = mutableListOf<MutableList<Int>>(newMenuImage,beverageImage,flatccinoImage,shakeAdeImage)

    var hotMenuImage = mutableListOf<Int>(
        R.drawable.americano,
        R.drawable.ainsupanner,
        R.drawable.strawberrylattee,
        R.drawable.strawberrymilkflatccino,
        R.drawable.strawberrypeach
    )
}