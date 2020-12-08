package com.yc.jiagu

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

/**
 * Author yichao
 * Time  2020/12/7 11:41
 * Dest
 *
 */
open class JiaGuTask : DefaultTask {
    var mjiaGuExt:JiaGuExt?=null
    var moutputFile:File?=null

    @Inject
    constructor( outputFile: File, jiaGuExt: JiaGuExt) {
        group = "task"
        mjiaGuExt=jiaGuExt
        moutputFile=outputFile
    }

    @TaskAction
    fun jiaGu() {
        //登录
project.exec {
    it.commandLine("java","-version",mjiaGuExt?.jiaguToolsPath,"-login",mjiaGuExt?.username,mjiaGuExt?.userpwd)

    //导入签名

    project.exec{
it.commandLine("java","-jar",mjiaGuExt?.jiaguToolsPath,"-importsign",mjiaGuExt?.keyStorePath,mjiaGuExt?.keyStoreAliasPwd,mjiaGuExt?.keyStoreAlias,mjiaGuExt?.keyStoreAliasPwd)


    }

    //加固

    project.exec {

println("moutputFile=${moutputFile?.absoluteFile}")
println("moutputFile.parent=${moutputFile?.parent}")
        it.commandLine("java","-jar",mjiaGuExt?.jiaguToolsPath,"-jiagu"
            ,moutputFile?.absoluteFile,moutputFile?.parent,"-autosign")


    }


}



    }

}