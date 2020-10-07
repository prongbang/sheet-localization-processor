package com.prongbang.aslprocessor.processor.sheet.data

import com.opencsv.CSVReader
import com.prongbang.aslprocessor.processor.sheet.domain.Sheet

interface SheetDataSource {
	fun download(sheet: Sheet): CSVReader
}