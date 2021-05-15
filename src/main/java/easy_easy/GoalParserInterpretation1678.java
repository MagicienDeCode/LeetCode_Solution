package easy_easy;

public class GoalParserInterpretation1678 {
    public String interpret(String command) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            final char currentChar = command.charAt(i);
            if (currentChar == 'G') {
                stringBuilder.append('G');
            } else if (currentChar == '(') {
                if (command.charAt(i + 1) == ')') {
                    stringBuilder.append('o');
                } else {
                    stringBuilder.append("al");
                }
            }
        }
        return stringBuilder.toString();
    }
}
