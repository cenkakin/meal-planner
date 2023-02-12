package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.common.BusinessValidationException

class InvalidRecipeException(message: String) : BusinessValidationException(message)
