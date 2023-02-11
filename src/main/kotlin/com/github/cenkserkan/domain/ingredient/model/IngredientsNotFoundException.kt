package com.github.cenkserkan.domain.ingredient.model

import com.github.cenkserkan.domain.common.BusinessValidationException
import java.util.UUID

class IngredientsNotFoundException(ids: List<UUID>) :
    BusinessValidationException("Ingredients with ids: $ids not found!")
