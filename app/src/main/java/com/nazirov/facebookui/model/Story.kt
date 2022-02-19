package com.nazirov.facebookui.model

class Story {
   var  profile: Int ? = null
   var  fullname: String? = null
    var createStory: Boolean = false

    constructor(){
        createStory = true
    }

    constructor(profile: Int, fullname: String) {
        createStory = false
        this.fullname= fullname
        this.profile = profile
    }

}