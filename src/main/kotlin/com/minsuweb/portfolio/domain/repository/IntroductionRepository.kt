package com.minsuweb.portfolio.domain.repository

import com.minsuweb.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}