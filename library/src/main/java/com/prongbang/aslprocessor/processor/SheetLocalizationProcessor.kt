package com.prongbang.aslprocessor.processor

import com.prongbang.aslprocessor.annotation.AndroidSheetLocalization
import com.prongbang.aslprocessor.processor.core.UseCase
import com.prongbang.aslprocessor.processor.sheet.Injector
import com.prongbang.aslprocessor.processor.sheet.domain.Sheet
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedSourceVersion(SourceVersion.RELEASE_8)
class SheetLocalizationProcessor : AbstractProcessor() {

	private var sheet = Sheet()
	private val generateLocalizeResourcesUseCase: UseCase<Sheet, Boolean> = Injector.provideGenerateLocalizeResourcesUseCase()

	override fun getSupportedAnnotationTypes() =
			mutableSetOf(AndroidSheetLocalization::class.java.canonicalName)

	override fun process(annotations: MutableSet<out TypeElement>?,
	                     roundEnv: RoundEnvironment): Boolean {
		if (roundEnv.processingOver()) {
			return true
		}

		for (element in roundEnv.getElementsAnnotatedWith(AndroidSheetLocalization::class.java)) {
			element.getAnnotation(AndroidSheetLocalization::class.java)
					?.let {
						sheet = Sheet(it.sheetId, it.documentId, it.enabled)
					}
		}

		if (!sheet.enabled) {
			return true
		}

		return generateLocalizeResourcesUseCase.execute(sheet)
	}

}