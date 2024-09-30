package com.minsuweb.portfolio.domain.repository

import com.minsuweb.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository:JpaRepository<Experience, Long>