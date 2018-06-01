@file:JvmName("Updater")

package org.runestar.client.updater

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.runestar.client.updater.common.ClassHook
import java.lang.invoke.MethodHandles
import java.net.URL

private val classLoader: ClassLoader get() = MethodHandles.lookup().lookupClass().classLoader

val hooksFile: URL get() = classLoader.getResource("hooks.json")

fun readHooks(): List<ClassHook> {
    return jacksonObjectMapper().readValue(hooksFile)
}

val gamepackUrl: URL get() = classLoader.getResource("gamepack.jar")

val cleanGamepackUrl: URL get() = classLoader.getResource("gamepack.clean.jar")