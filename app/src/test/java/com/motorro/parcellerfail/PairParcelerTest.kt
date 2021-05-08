package com.motorro.parcellerfail

import android.os.Parcel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PairParcelerTest {
    @Test
    fun parcels() {
        val interval = Pair(10, 20)
        val parcel = Parcel.obtain()
        val parceler = PairParceler(IntParceler, IntParceler)

        with (parceler) {
            interval.write(parcel, 0)
        }
        parcel.setDataPosition(0)

        assertEquals(interval, parceler.create(parcel))
    }
}