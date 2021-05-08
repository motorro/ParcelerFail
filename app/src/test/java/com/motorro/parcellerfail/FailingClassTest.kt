package com.motorro.parcellerfail

import android.os.Build
import android.os.Bundle
import android.os.Parcel
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class FailingClassTest {
    @Test
    fun parcels() {
        val failing = FailingClass(Pair(10, 20))
        val bundle = Bundle()
        bundle.putParcelable("test", failing)
        val fromParcel = bundle.deepCopy().getParcelable<FailingClass>("test")
        assertEquals(failing, fromParcel)
    }
}