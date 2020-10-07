package com.prongbang.aslprocessor.processor.core

interface UseCase<Param, Result> {
	fun execute(parameter: Param): Result
}