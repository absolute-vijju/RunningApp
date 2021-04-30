package com.developer.vijay.runningapp.other

import android.graphics.Color

object Constants {

    const val RUNNING_DATABASE_NAME = "running_db"

    const val REQUEST_CODE_LOCATION_PERMISSION = 0

    const val ACTION_START_OR_RESUME_SERVICE = "action_start_or_resume_service"
    const val ACTION_PAUSE_SERVICE = "action_pause_service"
    const val ACTION_STOP_SERVICE = "action_stop_service"
    const val ACTION_SHOW_TRACKING_FRAGMENT = "action_show_tracking_fragment"

    const val TIMER_UPDATE_INTERVAL=50L

    const val LOCATION_UPDATE_INTERVAL = 5000L
    const val FASTEST_LOCATION_INTERVAL = 2000L

    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Tracking"
    const val NOTIFICATION_ID = 1

    const val POLYLINE_COLOR = Color.RED
    const val POLYLINE_WIDTH = 8f
    const val MAP_ZOOM = 15f

    const val SHARED_PREFERENCES_NAME="sharedPref"
    const val KEY_FIRST_TIME_TOGGLE="key_first_time_toggle"
    const val KEY_NAME="key_name"
    const val KEY_WEIGHT="key_weight"

}