package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.common.BusinessValidationException

class RecipeLimitExceededException : BusinessValidationException("Cannot add more than 3 entries at once")
