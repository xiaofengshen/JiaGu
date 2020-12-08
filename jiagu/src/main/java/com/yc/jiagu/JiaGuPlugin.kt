package com.yc.jiagu

import com.android.build.gradle.AppExtension
import com.android.build.gradle.api.ApplicationVariant
import javafx.application.Application
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project

class JiaGuPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        val jiaGuPlugin = project.extensions.create("jiagu", JiaGuExt::class.java)


        project.afterEvaluate(Action {


            val appExtension = it.extensions.getByType(AppExtension::class.java)
            appExtension.applicationVariants.all(Action {applicationVariant ->

                applicationVariant.outputs.all(Action {baseVariantOutput ->

                    val outputFile = baseVariantOutput.outputFile
                    val name = baseVariantOutput.name

                    project.tasks.create("jiagu$name",JiaGuTask::class.java,outputFile,jiaGuPlugin)


                })


            })


        })


    }
}