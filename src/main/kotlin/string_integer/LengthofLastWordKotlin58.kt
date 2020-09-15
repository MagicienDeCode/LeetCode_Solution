package string_integer

class LengthofLastWordKotlin58 {

    fun lengthOfLastWord(s: String): Int {
        var result = 0
        var index = s.length - 1
        while (index >= 0 && s[index] == ' ') {
            --index
        }
        while (index >= 0 && s[index] != ' ') {
            ++result
            --index
        }
        return result
    }
    /*
    ! Wrong Answer!
   fun lengthOfLastWord(s: String): Int {
       val strings = s.split(" ");
       if (strings.isEmpty()) {
           return 0
       }
       return strings[strings.size - 1].length
   }
    */
}