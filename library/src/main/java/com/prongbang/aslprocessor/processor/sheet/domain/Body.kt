package com.prongbang.aslprocessor.processor.sheet.domain

import java.util.*

data class Body(
		val csvLine: Array<String> = arrayOf(),
		val supportedLocale: List<String> = listOf(),
		val localization: HashMap<String, String> = hashMapOf()
)