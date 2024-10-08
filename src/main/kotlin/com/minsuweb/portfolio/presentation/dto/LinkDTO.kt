package com.minsuweb.portfolio.presentation.dto

import com.minsuweb.portfolio.domain.entity.Link

class LinkDTO(
        val name: String,
        val content: String
) {
    constructor(link: Link) : this(
            name = link.name.lowercase(),
            content = link.content
    )
}