package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.common.BusinessValidationException
import java.util.UUID

class InvalidRecipeException(message: String) : BusinessValidationException(message)
