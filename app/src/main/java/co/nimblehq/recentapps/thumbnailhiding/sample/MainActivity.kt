package co.nimblehq.recentapps.thumbnailhiding.sample

import android.app.Activity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import co.nimblehq.recentapps.thumbnailhiding.RecentAppsThumbnailHidingActivity

class MainActivity : RecentAppsThumbnailHidingActivity() {
    override val enableSecureFlagOnLowApiDevices: Boolean = false

    override val enableSecureFlagOnCustomGestureNavigationDevices: Boolean = true
    private lateinit var ivRecentAppsLogo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivRecentAppsLogo = findViewById(R.id.ivRecentAppsLogo)
    }

    override fun onRecentAppsTriggered(
        activity: Activity,
        inRecentAppsMode: Boolean,
    ) {
        ivRecentAppsLogo.visibility = if (inRecentAppsMode) VISIBLE else GONE
    }
}
