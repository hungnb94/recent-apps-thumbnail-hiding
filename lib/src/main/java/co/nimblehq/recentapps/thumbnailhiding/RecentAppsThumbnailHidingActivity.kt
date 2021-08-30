package co.nimblehq.recentapps.thumbnailhiding

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class RecentAppsThumbnailHidingActivity : AppCompatActivity(), RecentAppsThumbnailHidingListener {

    protected open val enableSecureFlagOnLowApiDevices: Boolean = false

    /**
     * HardwareKeyWatcher doesn't work on API 25 or lower,
     * allow to use FLAG_SECURE instead to hide app thumbnail.
     */
    val isSecureFlagEnabled: Boolean
        get() = enableSecureFlagOnLowApiDevices && Build.VERSION.SDK_INT < Build.VERSION_CODES.O

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isSecureFlagEnabled) {
            enableSecureFlag(true)
        }
    }
}
