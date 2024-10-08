package com.minsuweb.portfolio.presentation.dto

import com.minsuweb.portfolio.domain.entity.Introduction

data class IntroductionDTO(
        val content: String
) {
    constructor(introduction: Introduction) : this(
            content = introduction.content
    )
}