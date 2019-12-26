import java.util.*;

public class LeetCode_17_0190 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null) return result;
        char[] chars = digits.toCharArray();
        if (chars.length == 0) return result;

        HashMap<Integer, ArrayList<Character>> map = new HashMap<>(8);
        map.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));


        this.help(result, map, chars, 0, new char[chars.length]);
        return result;
    }

    private void help(List<String> result, HashMap<Integer, ArrayList<Character>> map, char[] chars, int index, char[] temp) {
        if (chars.length == index) {
            result.add(new String(temp));
            return;
        }
        ArrayList<Character> characterArrayList = map.get(Integer.parseInt(String.valueOf(chars[index])));
        for (Character character : characterArrayList) {
            temp[index] = character;
            this.help(result, map, chars, index + 1, temp);
        }
    }
}
