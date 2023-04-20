package com.driuft.sharedlifecycle

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var sp: SharedPreferences
    private val spListener = OnSharedPreferenceChangeListener { sharedPreferences, key ->
        Toast.makeText(
            this,
            sharedPreferences.getString(
                key,
                resources.getString(R.string.default_state)
            ),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)
        sp.registerOnSharedPreferenceChangeListener(spListener)

        with (sp.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onCreate")
            apply()
        }

        sp.unregisterOnSharedPreferenceChangeListener(spListener)
        //Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
        /*    with (sp.edit()) {
            // replace "onCreate" with the name of the method you're saving
            putString(getString(R.string.current_lifecycle_state), "onCreate")
            apply()
        }
        val currentState = sp.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log statement at debug level
        Log.d("Lifecycle: ", currentState)
        // Toast
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
        */

    }

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()

        sp.registerOnSharedPreferenceChangeListener(spListener)

        with (sp.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStart")
            apply()
        }

        sp.unregisterOnSharedPreferenceChangeListener(spListener)


        /*with (sp.edit()) {
            // replace "onCreate" with the name of the method you're saving
            putString(getString(R.string.current_lifecycle_state), "onStart")
            apply()
        }

        val currentState = sp.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log statement at debug level
        Log.d("Lifecycle: ", currentState)
        // Toast
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()*/
    }

    override fun onResume() {
        super.onResume()

        sp.registerOnSharedPreferenceChangeListener(spListener)

        with (sp.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onResume")
            apply()
        }

        sp.unregisterOnSharedPreferenceChangeListener(spListener)


        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        /*with (sp.edit()) {
            // replace "onCreate" with the name of the method you're saving
            putString(getString(R.string.current_lifecycle_state), "onResume")
            apply()
        }

        val currentState = sp.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)

        // Log statement at debug level
        Log.d("Lifecycle: ", currentState)
        // Toast
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()*/
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}