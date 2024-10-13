package com.minsuweb.portfolio.admin.context.skill.service

import com.minsuweb.portfolio.admin.context.skill.form.SkillForm
import com.minsuweb.portfolio.admin.data.TableDTO
import com.minsuweb.portfolio.domain.entity.Skill
import com.minsuweb.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService(
        private val skillRepository: SkillRepository
) {

    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: SkillForm) {
        val skill = form.toEntity()

        skillRepository.save(skill)
    }

    @Transactional
    fun update(id: Long, form: SkillForm) {
        val skill = form.toEntity(id)

        skillRepository.save(skill)
    }
}