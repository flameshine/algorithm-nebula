package com.flameshine.nebula.archive

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 */

fun main() {

    println(
        defangIpAddress("1.1.1.1")
    )
}

private fun defangIpAddress(address: String): String {

    val result = StringBuilder()

    for (i in address.indices) {
        if (address[i] == '.') result.append("[.]") else result.append(address[i])
    }

    return result.toString()
}