package com.developer.vijay.runningapp.other

import android.content.Context
import android.widget.TextView
import com.developer.vijay.runningapp.R
import com.developer.vijay.runningapp.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    val runs: List<Run>,
    context: Context,
    layoutId: Int
) : MarkerView(context, layoutId) {

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (e == null)
            return

        val currentRunId = e.x.toInt()
        val run = runs[currentRunId]

        val calender = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }

        val tvDate = findViewById<TextView>(R.id.tvDate)
        val tvDuration = findViewById<TextView>(R.id.tvDuration)
        val tvDistance = findViewById<TextView>(R.id.tvDistance)
        val tvAvgSpeed = findViewById<TextView>(R.id.tvAvgSpeed)
        val tvCaloriesBurned = findViewById<TextView>(R.id.tvCaloriesBurned)

        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        tvDate.text = dateFormat.format(calender.time)

        val avgSpeed = "${run.avgSpeedInKMH}km/h"
        tvAvgSpeed.text = avgSpeed

        val distanceInKm = "${run.distanceInMeters / 1000f}km"
        tvDistance.text = distanceInKm

        tvDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

        val caloriesBurned = "${run.caloriesBurned}kcal"
        tvCaloriesBurned.text = caloriesBurned


    }

}