package com.minsuweb.portfolio.domain.repository

import com.minsuweb.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository:JpaRepository<Achievement, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Achievement>

}