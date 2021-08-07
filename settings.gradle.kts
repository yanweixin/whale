rootProject.name = "whale"

File("$rootDir/whale-web").list { dir, name -> File(dir, name).isDirectory && name != "build" }!!.forEach {
    include("whale-web:$it")
}

File("$rootDir/whale-utils").list { dir, name -> File(dir, name).isDirectory && name != "build" }!!.forEach {
    include("whale-utils:$it")
}

File("$rootDir/whale-data").list { dir, name -> File(dir, name).isDirectory && name != "build" }!!.forEach {
    include("whale-data:$it")
}

File("$rootDir/whale-components").list { dir, name -> File(dir, name).isDirectory && name != "build" }!!.forEach {
    include("whale-components:$it")
}