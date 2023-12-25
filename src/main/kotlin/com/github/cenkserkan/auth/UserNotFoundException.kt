package com.github.cenkserkan.auth

import com.github.cenkserkan.domain.common.BusinessValidationException

class UserNotFoundException(email: String) : BusinessValidationException("User with email $email doesn't exist in db!")
