package Test03_split;

import java.util.regex.Pattern;

public class MySplitter {
    public static void main(String[] argv) {
        test_splitString();
    }
    
    private static void test_splitString() {
        String s1 = "http://abc/def%20xyz";
        String s2 = "https://zzz/aaa%20fff";
        
        // char delimiter = '\n'; // does not work
        String delimiter = "\n";
        
        String bigStr = s1 + delimiter + s2 + delimiter;
        
        String[] strArray1 = null;
        if (bigStr.contains(delimiter)) {
            strArray1 = bigStr.split(delimiter);
        }
        
        for (int i=0; i<strArray1.length; i++) {
            /*
             * 0 : http://abc/def%20xyz
               1 : https://zzz/aaa%20fff
             */
            System.out.println(i + " : " + strArray1[i]);
        }
        
        String[] strArray2 = null;
        if (bigStr.contains(delimiter)) {
            strArray2 = bigStr.split(Pattern.quote(delimiter));
        }
        
        for (int i=0; i<strArray2.length; i++) {
            /*
             * 0 : http://abc/def%20xyz
               1 : https://zzz/aaa%20fff
             */
            System.out.println(i + " : " + strArray2[i]);
        }
    
    }
}
