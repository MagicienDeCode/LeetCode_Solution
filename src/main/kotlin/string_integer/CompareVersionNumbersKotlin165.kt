package string_integer

class CompareVersionNumbersKotlin165 {
    fun compareVersion(version1: String, version2: String): Int {
        var index1 = 0
        var index2 = 0
        while (index1 < version1.length || index2 < version2.length) {
            var temp1 = 0
            var temp2 = 0
            while (index1 < version1.length && version1[index1] != '.') {
                temp1 = temp1 * 10 + (version1[index1] - '0')
                ++index1
            }
            ++index1
            while (index2 < version2.length && version2[index2] != '.') {
                temp2 = temp2 * 10 + (version2[index2] - '0')
                ++index2
            }
            ++index2
            if (temp1 > temp2) {
                return 1
            }
            if (temp1 < temp2) {
                return -1
            }
        }
        return 0
    }
}