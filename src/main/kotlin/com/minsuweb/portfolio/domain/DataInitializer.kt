package com.minsuweb.portfolio.domain

import com.minsuweb.portfolio.domain.constant.SkillType
import com.minsuweb.portfolio.domain.entity.*
import com.minsuweb.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
        private val achievementRepository: AchievementRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val skillRepository: SkillRepository,
        private val projectRepository: ProjectRepository,
        private val experienceRepository: ExperienceRepository,
        private val accountRepository: AccountRepository
) {

    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {

        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement> (
                Achievement(
                        title = "프로젝트 우수상",
                        description = "React, TypeScript, Spring Boot로 사용자 친화적 UI, JWT 인증, 소셜 로그인 API 연동, 안정적인 DB 설계를 성공적으로 수행",
                        host = "멀티캠퍼스",
                        achievedDate = LocalDate.of(2024, 6, 14),
                        isActive = true
                ),
                Achievement(
                        title = "프로젝트 최우수상",
                        description = "JavaScript와 Spring을 활용해 CRUD 기능, 페이징, 좋아요 기능을 안정적으로 구현",
                        host = "멀티캠퍼스",
                        achievedDate = LocalDate.of(2024, 3, 29),
                        isActive = true
                ),
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction> (
                Introduction(content = "끊임없이 문제를 분석하고, 해결하는 개발자입니다.", isActive = true),
                Introduction(content = "주도적으로 프로젝트를 이끌며, 최적화된 백엔드 구조를 설계합니다.", isActive = true),
                Introduction(content = "프로젝트 전반에서 책임감을 가지고, 목표 달성을 위해 끊임없이 개선점을 찾아 반영합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link> (
                Link(name = "Github", content = "https://github.com/suover", isActive = true),
                Link(name = "pencil-square", content = "https://suover.com/", isActive = true),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience (
                title = "Java & Spring 강의 수강",
                description = "인프런",
                startYear = 2024,
                startMonth = 8,
                endYear = null,
                endMonth = null,
                isActive = true,
        )
        experience1.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "Java와 Spring Framework를 심도 있게 학습하여 백엔드 개발 역량 강화", isActive = true),
                        ExperienceDetail(content = "실무 프로젝트에 적용할 수 있는 기술을 체계적으로 익히며, 더 나은 개발자가 되기 위한 지속적인 성장 도모", isActive = true)
                )
        )
        val experience2 = Experience (
                title = "풀스택 개발자 취업캠프(Java)",
                description = "멀티캠퍼스",
                startYear = 2023,
                startMonth = 12,
                endYear = 2024,
                endMonth = 6,
                isActive = true,
        )
        experience2.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "Java와 Spring Framework를 활용한 실무 중심 학습", isActive = true),
                        ExperienceDetail(content = "JavaScript, React를 학습하여 UI와 UX 최적화 역량 강화", isActive = true),
                        ExperienceDetail(content = "Git을 통한 형상 관리와 GitHub를 활용한 팀 프로젝트 협업 경험", isActive = true),
                        ExperienceDetail(content = "두 번의 팀 프로젝트에서 팀장 역할 수행, 각각 최우수상 및 우수상 수상", isActive = true)
                )
        )
        val experience3 = Experience(
                title = "자바스크립트 활용 과정",
                description = "경기도일자리재단",
                startYear = 2023,
                startMonth = 8,
                endYear = 2023,
                endMonth = 11,
                isActive = true,
        )
        experience3.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "HTML, CSS, JavaScript 학습", isActive = true),
                        ExperienceDetail(content = "웹 브라우저의 동작 방식과 JavaScript 동작 원리 이해", isActive = true),
                        ExperienceDetail(content = "웹 표준 준수 및 UI와 UX 최적화 능력 강화", isActive = true)
                )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2, experience3))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val javascript = Skill(name = "JavaScript", type = SkillType.LANGUAGE.name, isActive = true)
        val typescript = Skill(name = "TypeScript", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val springBoot = Skill(name = "SpringBoot", type = SkillType.FRAMEWORK.name, isActive = true)
        val react = Skill(name = "React", type = SkillType.FRAMEWORK.name, isActive = true)
        val mybatis = Skill(name = "MyBatis", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        val github = Skill(name = "GitHub", type = SkillType.TOOL.name, isActive = true)
        val docker = Skill(name = "Docker", type = SkillType.TOOL.name, isActive = true)
        val aws = Skill(name = "AWS", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, javascript, typescript, spring, springBoot, react, mybatis, mysql, oracle, github, docker, aws))

        val project1 = Project(
                name = "운동 종합 커뮤니티 및 쇼핑몰 프로젝트 [ FitOn ]",
                description = "운동 루틴 기록과 관련 용품 쇼핑을 한 곳에서 해결할 수 있는 플랫폼. 실시간 운동 정보 공유와 쇼핑 기능을 통합하여 사용자 편의성을 향상.",
                startYear = 2024,
                startMonth = 4,
                endYear = 2024,
                endMonth = 7,
                isActive = true
        )
        project1.addDetails(
                mutableListOf(
                        ProjectDetail(content = "Spring Boot를 활용한 REST API 설계 및 구현", url = null, isActive = true),
                        ProjectDetail(content = "MyBatis를 통해 데이터베이스와의 효율적인 연동", url = null, isActive = true),
                        ProjectDetail(content = "정규화를 통한 데이터베이스 설계로 데이터 관리 효율성을 개선", url = null, isActive = true),
                        ProjectDetail(content = "Spring Security와 JWT를 활용한 사용자 인증 및 권한 관리 구현", url = null, isActive = true),
                        ProjectDetail(content = "구글, 네이버, 카카오 소셜 로그인 API 연동을 통해 사용자 편의성 향상", url = null, isActive = true),
                        ProjectDetail(content = "AWS EC2, RDS를 사용하여 클라우드 인프라를 안정적으로 구축", url = null, isActive = true),
                        ProjectDetail(content = "Docker와 Nginx를 사용한 자동화 배포 환경 설정", url = null, isActive = true),
                        ProjectDetail(content = "CI/CD 파이프라인 구축을 통해 배포 소요 시간 30분 → 3분으로 단축", url = null, isActive = true),
                        ProjectDetail(content = "Github Repository", url = "https://github.com/suover/fit-on", isActive = true),
                        ProjectDetail(content = "Project Link", url = "https://fiton.kr/", isActive = true),
                        ProjectDetail(content = "Notion Link", url = "https://suover.notion.site/Fit-On-4c9438e2fcd24edf95cf51f2d912b85f?pvs=4", isActive = true),
                        ProjectDetail(content = "ERD Link", url = "https://www.erdcloud.com/d/PhhZMaP3zEJExyz44", isActive = true),
                        ProjectDetail(content = "Presentation Link", url = "https://www.miricanvas.com/v/13a1s7j", isActive = true)
                )
        )
        project1.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project1, skill = java),
                        ProjectSkill(project = project1, skill = springBoot),
                        ProjectSkill(project = project1, skill = react),
                        ProjectSkill(project = project1, skill = mysql),
                        ProjectSkill(project = project1, skill = mybatis)
                )
        )

        val project2 = Project(
                name = "OTT 통합 검색 커뮤니티 [ OTT Search ]",
                description = "다양한 OTT 플랫폼의 콘텐츠를 한곳에서 검색하고 공유할 수 있는 커뮤니티 서비스. 콘텐츠 검색의 편의성과 사용자 경험을 개선하기 위한 작업 수행.",
                startYear = 2024,
                startMonth = 2,
                endYear = 2024,
                endMonth = 3,
                isActive = true
        )
        project2.addDetails(
                mutableListOf(
                        ProjectDetail(content = "Spring과 MyBatis를 활용해 게시판 및 댓글 CRUD 기능 구현", url = null, isActive = true),
                        ProjectDetail(content = "데이터를 효율적으로 저장하고 관리하기 위한 관계형 데이터베이스 설계", url = null, isActive = true),
                        ProjectDetail(content = "AJAX를 통한 실시간 조회수 및 좋아요 기능 구현으로 사용자 경험 향상", url = null, isActive = true),
                        ProjectDetail(content = "Github Repository", url = "https://github.com/suover/ott-search", isActive = true),
                        ProjectDetail(content = "Notion Link", url = "https://suover.notion.site/OTT-Search-5afd9d0299a245488349b99b313bf4bf?pvs=4", isActive = true),
                        ProjectDetail(content = "ERD Link", url = "https://www.erdcloud.com/d/ZMoBcWZHmsWeuYHHB", isActive = true),
                        ProjectDetail(content = "Presentation Link", url = "https://www.miricanvas.com/v/12zjvry", isActive = true)
                )
        )
        project2.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project2, skill = java),
                        ProjectSkill(project = project2, skill = spring),
                        ProjectSkill(project = project2, skill = javascript),
                        ProjectSkill(project = project2, skill = oracle),
                        ProjectSkill(project = project2, skill = mybatis)
                )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
                loginId = "admin1",
                pw = "\$2a\$10\$VOoX26RkKbiPutDkFcMJNuLUmdVzBwkxmm9F4kWj3htHJEv.XLHnC"
        )
        accountRepository.save(account)
    }
}