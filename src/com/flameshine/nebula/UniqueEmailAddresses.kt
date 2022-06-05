package com.flameshine.nebula

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign.
 * Besides lowercase letters, the email may contain one or more '.' or '+'.
 * If you add periods '.' between some characters in the local name of an email address, mail sent there will be forwarded to the same address without dots in the local name.
 * Note that this rule does not apply to domain names.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered.
 * Note that this rule does not apply to domain names.
 * It's possible to use both of these rules at the same time.
 * Given an array of strings 'emails', return the number of different addresses that actually receive emails.
 */

private const val AT_SIGN = '@'

fun main() {

    val emails = arrayOf(
        "test.email+alex@leetcode.com",
        "test.e.mail+bob.cathy@leetcode.com",
        "testemail+david@lee.tcode.com"
    )

    println(
        numUniqueEmails(emails)
    )
}

fun numUniqueEmails(emails: Array<String>): Int {
    return emails.map { email -> processEmail(email) }.distinct().size
}

private fun processEmail(email: String): String {

    val local = email.substringBefore(AT_SIGN)
        .substringBefore('+')
        .replace(".", "")

    val domain = email.substringAfter(AT_SIGN)

    return StringBuilder()
        .append(local)
        .append(AT_SIGN)
        .append(domain)
        .toString()
}