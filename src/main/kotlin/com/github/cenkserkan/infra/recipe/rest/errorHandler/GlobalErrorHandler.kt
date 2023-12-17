package com.github.cenkserkan.infra.recipe.rest.errorHandler

import com.github.cenkserkan.domain.common.BusinessValidationException
import com.github.cenkserkan.domain.recipe.usecase.RecipeNotFoundException
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(ex: ConstraintViolationException): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.message!!)
            .apply { this.title = "Invalid Request" }
    }

    @ExceptionHandler(BusinessValidationException::class)
    fun handleBusinessValidationException(ex: BusinessValidationException): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.message!!)
            .apply { this.title = "Validation error happened" }
    }

    @ExceptionHandler(RecipeNotFoundException::class)
    fun handleRecipeNotFoundException(ex: RecipeNotFoundException): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.message!!)
    }
}
