import java.util.*;


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int letterCount = 0, start = 0, end = 0;
        for (int i = 0; i < words.length; i++) {
            letterCount += words[i].length() + 1;
            end = i;
            if (i == words.length - 1 || letterCount + words[i + 1].length() > maxWidth) {
                StringBuilder sb = new StringBuilder();
                if (i == words.length - 1 || end - start + 1 == 1) {
                    for (int j = start; j < end; j++) {
                        sb.append(words[j]);
                        sb.append(" ");
                    }
                    sb.append(words[end]);
                    int extraSpace = maxWidth - sb.length();
                    for (int j = 0; j < extraSpace; j++)
                        sb.append(" ");
                    result.add(sb.toString());
                } else {
                    letterCount -= end - start + 1;
                    int spaces = (maxWidth - letterCount) / (end - start);
                    int extraSpace = (maxWidth - letterCount) % (end - start);
                    for (int j = start; j < end; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < spaces; k++)
                            sb.append(" ");
                        if (extraSpace != 0) {
                            sb.append(" ");
                            extraSpace--;
                        }
                    }
                    sb.append(words[end]);
                    result.add(sb.toString());
                }
                start = i + 1;
                letterCount = 0;
            }
        }
        return result;
    }
}