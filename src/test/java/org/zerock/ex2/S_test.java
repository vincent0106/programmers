package org.zerock.ex2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class S_test {

    private HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyists(String hobby) {
        List<String> result = new ArrayList<>();
        for (String key : this.hobbies.keySet()) {
            String[] hobbiesList = hobbies.get(key);
            if (Arrays.asList(hobbiesList).contains(hobby)){
                result.add(key);
            }
        }
    return result;
//        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    @Test
    public void test() {

        add("Steve", "Fashion", "Piano", "Reading");
        add("Patty", "Drama", "Magic", "Pets");
        add("Chad", "Puzzles", "Pets", "Yoga");

        System.out.println(Arrays.toString(findAllHobbyists("Yoga").toArray()));
    }
    //### 2


    public static int getOccurrenceCount(String toSearch, InputStream stream) throws Exception {

        int count = 0;
        String message = new String(stream.readAllBytes());
        String[] list = message.split("\n");
        for (String m : list) {
            if (m.contains(toSearch)){
                count++;
            }
        }
        return count;
//        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    @Test
    public void test2() throws Exception {
        String msg = "Hey! How are you?\nI am good, how about you?\nI am good too.";

        try(InputStream stream = new ByteArrayInputStream(msg.getBytes())) {
            System.out.println(getOccurrenceCount("good", stream));
        }
    }

    // ### 3


    public String simplify(String input) {

        String before = null;
        String result = "";

        for (String s : input.split("")) {
            if ( before == null ){
                before = s;
                continue;
            }
            if ( before.equals(s)){
                continue;
            }
            result = s;
        }
        return result;


//        return Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
    }

    @Test
    public void test3() {
        System.out.println(simplify("ghhrkkb"));
    }

}
