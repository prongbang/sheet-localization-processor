package com.prongbang.aslprocessor.processor.sheet.domain

import com.prongbang.aslprocessor.processor.core.UseCase

class GetLocaleUseCase : UseCase<String, String> {

	override fun execute(parameter: String): String {
		val keyRegex = "\\((\\w\\w*)\\)".toRegex()
		var matchKey = parameter
		val match = keyRegex.find(matchKey)
		if (match != null) {
			matchKey = match.value.replace("(", "")
					.replace(")", "")
		}
		return matchKey
	}
}