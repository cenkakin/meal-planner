package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.common.BusinessValidationException

class RecipeLimitExceededException: BusinessValidationException("User cannot save more recipes!") {
}