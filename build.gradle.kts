extra.apply {
    set("junitVersion", "5.7.2")
    set("jmhVersion", "1.32")
    set("springVersion", "2.5.5")
    set("vertxVersion", "4.1.5")
    set("grpcVersion", "1.41.0")
    set("protocVersion", "3.17.2")
    set("elasticVersion", "7.15.1")
    set("redissonVersion", "3.16.3")
    set("caffeineVersion", "3.0.3")
    set("poiVersion", "5.0.0")
    set("jacksonVersion", "2.13.0")
    set("commonsLangVersion", "3.12.0")
    set("commonTextVersion", "1.9")
    set("snakeYamlVersion", "1.29")
    set("univocityVersion", "2.9.1")
    set("amqpVersion", "5.13.1")
    set("kafkaVersion", "3.0.0")
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