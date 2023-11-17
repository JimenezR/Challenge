package com.platform.data.models

import com.platform.data.models.response.DefaultFailure

sealed class Failure {

    data class DatabaseException(
        override val message: String
    ) : DatabaseFailure, Failure()

    data class UnknownFailure(
        override val message: String
    ): DefaultFailure, Failure()

}