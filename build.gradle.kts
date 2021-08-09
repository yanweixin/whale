allprojects {
    configurations {
        all {
            exclude("org.springframework.boot", "spring-boot-starter-logging")
            exclude("org.springframework.boot", "spring-boot-starter-tomcat")
        }
    }
}

subprojects {
    val buildStr = "build"
    val publishToMavenLocalStr = "publishToMavenLocal"
    val allTasks = project.getAllTasks(false)
    if (project.subprojects.isEmpty()) {
        val taskMap = allTasks[this]?.associateBy({ it.name }, { it })
        if (taskMap != null) {
            if (taskMap.contains(buildStr) && taskMap.contains(publishToMavenLocalStr)) {
                taskMap[buildStr]?.finalizedBy(taskMap[publishToMavenLocalStr])
            }
        }
    }
}