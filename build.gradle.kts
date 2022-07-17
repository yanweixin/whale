extra.apply {
    set("junitVersion", "5.8.2")
    set("assertjVersion", "3.22.0")
    set("jmhVersion", "1.34")
    set("springVersion", "2.7.0")
    set("vertxVersion", "4.3.1")
    set("grpcVersion", "1.43.2")
    set("protocVersion", "3.19.3")
    set("elasticVersion", "8.2.3")
    set("redissonVersion", "3.17.4")
    set("caffeineVersion", "3.1.1")
    set("poiVersion", "5.2.2")
    set("easyexcelVersion", "3.1.1")
    set("jacksonVersion", "2.13.3")
    set("commonsLangVersion", "3.12.0")
    set("commonTextVersion", "1.9")
    set("commonIoVersion", "2.11.0")
    set("snakeYamlVersion", "1.30")
    set("univocityVersion", "2.9.1")
    set("amqpVersion", "5.14.1")
    set("kafkaVersion", "3.1.0")
    set("curatorVersion", "5.2.0")
    set("hibernateValidatorVersion", "7.0.4.Final")
}

allprojects {
    configurations {
        all {
            exclude("org.springframework.boot", "spring-boot-starter-logging")
            exclude("org.springframework.boot", "spring-boot-starter-tomcat")
            resolutionStrategy.eachDependency {
                when (requested.group) {
                    "io.grpc" -> useVersion(rootProject.extra.get("grpcVersion") as String)
                    "com.google.protobuf" -> useVersion(rootProject.extra.get("protocVersion") as String)
                }
            }
        }
    }
}

subprojects {
    val buildStr = "publish"
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

tasks.register("start") {
    val taskMap: MutableMap<Project, JavaExec> = mutableMapOf()
    allprojects {
        project.tasks.withType(JavaExec::class.java).forEach { javaExec ->
            taskMap[project]?.let {
                if (it.name != "bootRun" && it.name == "run") {
                    taskMap[project] = it
                }
            } ?: run {
                taskMap[project] = javaExec
            }
        }
    }
    taskMap.forEach {
        val p = it.key
        val t = it.value
        if (p.parent?.name == "whale-web" || p.name in setOf("whale-rdbms", "whale-common-service")) {
            println("Start running ${p.name} -> ${t.name}")
            dependsOn(t.path)
        }
    }
}