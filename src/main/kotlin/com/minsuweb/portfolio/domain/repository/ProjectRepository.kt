package com.minsuweb.portfolio.domain.repository

import com.minsuweb.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository:JpaRepository<Project, Long>