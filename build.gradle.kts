extra.apply {
    set("jmhVersion", "1.35")
    set("vertxVersion", "4.3.8")
    set("grpcVersion", "1.53.0")
    set("protocVersion", "3.22.0")
    set("grpcKotlinVersion", "1.3.0")
    set("redissonVersion", "3.19.3")
    set("poiVersion", "5.2.2")
    set("easyexcelVersion", "3.2.1")
    set("commonTextVersion", "1.9")
    set("commonIoVersion", "2.11.0")
    set("commonsMathVersion","3.6.1")
    set("univocityVersion", "2.9.1")
    set("curatorVersion", "5.3.0")
}

allprojects {
    configurations {
        all {
            exclude("org.springframework.boot", "spring-boot-starter-logging")
            exclude("org.springframework.boot", "spring-boot-starter-tomcat")
            resolutionStrategy.eachDependency {
                when (requested.group) {
                    "io.grpc" -> if (requested.name.contains("kotlin")) {
                        useVersion(rootProject.extra.get("grpcKotlinVersion") as String)
                    } else {
                        useVersion(rootProject.extra.get("grpcVersion") as String)
                    }

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