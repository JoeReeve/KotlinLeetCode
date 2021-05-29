package Strings

class DefangedIPAddress {

    fun defangIPaddr(address: String): String {
        val defanged = StringBuilder()
        for (letter in address) {
            if (Character.toString(letter) == ".") defanged.append("[.]")
            else defanged.append(letter)
        }
        return defanged.toString()
    }
}