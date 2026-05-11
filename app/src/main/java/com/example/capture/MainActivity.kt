package com.example.capture

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.capture.fragments.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            openFragment(SensorsListFragment())
        }
    }

    fun openFragment(f: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, f)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 1, 0, "Liste Capteurs")
        menu.add(0, 2, 0, "Environnement")
        menu.add(0, 3, 0, "Mouvement")
        menu.add(0, 4, 0, "Podomètre")
        menu.add(0, 5, 0, "Boussole")
        menu.add(0, 6, 0, "Activité")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> openFragment(SensorsListFragment())
            2 -> openFragment(SensorGraphFragment())
            3 -> openFragment(MotionSensorFragment())
            4 -> openFragment(StepCounterFragment())
            5 -> openFragment(CompassFragment())
            6 -> openFragment(ActivityRecognitionFragment())
        }
        return true
    }
}