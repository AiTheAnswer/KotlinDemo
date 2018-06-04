package io

import java.io.File

// Kotlin 的IO流

/**
 * 一、读文件
 * 1.1、读取文件全部内容
 * readText()
 */
fun readFile(fileName: String): String {
    val file = File(fileName)
    var result = ""
    if (file.exists() && file.isFile) {
        result = file.readText(Charsets.UTF_8)
    }
    return result
}

/**
 * 1.2 获取文件没行的内容
 * readLines()
 */
fun getFileLines(fileName: String): List<String> {
    val file = File(fileName)
    var readLines: List<String> = mutableListOf()
    if (file.exists() && file.isFile) {
        readLines = file.readLines()
    }
    return readLines
}

/**
 * 1.3 直接操作字节数组
 * 可以直接使用Java中的Reader、InputStream、BufferedReader等
 */
fun copyByteFile(fileName: String, targetPath: String): Boolean {
    val sourceFile = File(fileName)
    val targetFile = File(targetPath)
    var result = false
    if (sourceFile.exists() && sourceFile.isFile) {
        if (!targetFile.exists()) {
            targetFile.createNewFile()
        }
        val readBytes = sourceFile.readBytes()
        val outputStream = targetFile.outputStream()
        outputStream.write(readBytes)
        result = true
    }
    return result
}

/**
 * 二、写文件
 * 2.1 覆盖写文件
 * writeText(text)
 */
fun writeFile(text: String, destFile: String) {
    val file = File(destFile)
    if (!file.exists()) {
        file.createNewFile()
    }
    file.writeText(text)
}

/**
 * 2.2 末尾追加写文件
 * appendText(text)
 */
fun appendFile(text: String, destFile: String) {
    val file = File(destFile)
    if(!file.exists()){
        file.createNewFile()
    }
    file.appendText(text)
}

/**
 * 三、 遍历文件树
 * walk()
 */
fun traverseFileTree(fileName: String): FileTreeWalk{
    val file = File(fileName)
    return file.walk()
}

fun main(args: Array<String>) {
    //读文件全部内容
    val result = readFile("E:\\Kotlin\\Kotlin的IO流\\Kotlin的IO流.txt")
    println(result)
    //读文件每一行的内容
    val fileLines = getFileLines("E:\\Kotlin\\Kotlin的IO流\\Kotlin的IO流.txt")
    for (indexValue in fileLines.withIndex()) {
        println("index = ${indexValue.index} ")
        println("value = ${indexValue.value}")
    }
    //读字节流
    val copyByteFile = copyByteFile("E:\\Kotlin\\Kotlin的IO流\\a.jpg", "E:\\Kotlin\\Kotlin的IO流\\copy_a.jpg")
    println(copyByteFile)
    //写文件，覆盖原数据
    writeFile("我是新写入的数据，并覆盖了原来的数据","E:\\Kotlin\\Kotlin的IO流\\writeFile.txt")
    //在原文件后面是添加数据
    appendFile("""
         -------以下是新增的文本-----
         时间上有多少人
         会不会有人心疼
         早就告别了单纯
        ""","E:\\Kotlin\\Kotlin的IO流\\appendFile.txt")
    //遍历文件树
    val traverseFileTree = traverseFileTree("E:\\Kotlin\\Kotlin的IO流")
    val iterator = traverseFileTree.iterator()
    iterator.forEach {
        println("fileName = ${it.name}")
    }
}