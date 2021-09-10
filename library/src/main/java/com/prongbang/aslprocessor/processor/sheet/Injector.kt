package com.prongbang.aslprocessor.processor.sheet

import com.prongbang.aslprocessor.processor.core.UseCase
import com.prongbang.aslprocessor.processor.sheet.data.remote.GoogleSheetApi
import com.prongbang.aslprocessor.processor.sheet.data.remote.SheetRemoteDataSource
import com.prongbang.aslprocessor.processor.sheet.domain.GenerateLocalizeResourcesUseCase
import com.prongbang.aslprocessor.processor.sheet.domain.GenerateStringUseCase
import com.prongbang.aslprocessor.processor.sheet.domain.GetLocaleUseCase
import com.prongbang.aslprocessor.processor.sheet.domain.Sheet
import com.prongbang.aslprocessor.processor.utils.ResourceFileUtility

object Injector {

	fun provideGenerateLocalizeResourcesUseCase(): UseCase<Sheet, Boolean> =
			GenerateLocalizeResourcesUseCase(
					SheetRemoteDataSource(GoogleSheetApi()),
					GenerateStringUseCase(),
					GetLocaleUseCase(),
					ResourceFileUtility()
			)
}