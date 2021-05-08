package com.motorro.parcellerfail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.TypeParceler

@Parcelize
@TypeParceler<Pair<Int, Int>, IntToIntParceler>
data class FailingClass(val pair: Pair<Int, Int>): Parcelable