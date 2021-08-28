extra.apply {
    set("junitVersion", "5.7.2")
    set("jmhVersion", "1.32")
    set("springVersion", "2.5.4")
    set("vertxVersion", "4.1.2")
    set("grpcVersion", "1.40.1")
    set("protocVersion", "3.17.3")
    set("elasticVersion", "7.15.0-SNAPSHOT")
    set("redissonVersion", "3.16.1")
    set("caffeineVersion", "3.0.3")
    set("jacksonVersion", "2.12.5")
    set("commonsLangVersion", "3.12.0")
    set("commonTextVersion", "1.9")
}

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