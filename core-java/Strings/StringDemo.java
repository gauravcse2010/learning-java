public class StringDemo {
    public static void main(String[] args) {
    // 1. join
        String join = String.join("-", "a", "b");
        System.out.println("join: "+join);             //join: a-b

    // 2. repeat
        String repeat = "Java ".repeat(3);
        System.out.println("repeat: "+repeat);         //repeat: Java Java Java

    // 3. chatAt
        String name = "Gaurav";
        char nameCharAt2 = name.charAt(2);
        System.out.println("nameCharAt2: "+nameCharAt2); //nameCharAt2: u

    //4. indexOf - find location of substring
    //   indexOf(String str, int fromIndex)
    //   indexOf(String str, int fromIndex, int toIndex) - search stops at toIndex {toIndex is exclusive}
    //   returns -1 if not found

        String sub = "a";
        int start = name.indexOf(sub);
        int end = name.lastIndexOf(sub);
        int lastIndexOfWithEnd = name.lastIndexOf("a",3);
        System.out.println("start: "+start);            //start: 1
        System.out.println("end: "+end);                //end: 4
        System.out.println("lastIndexOfWithEnd: "+lastIndexOfWithEnd); //lastIndexOfWithEnd: 1

    //5. substring
        // String substring(int beginIndex)
        // String substring(int beginIndex, int endIndex)
        String subString1 = name.substring(2);
        System.out.println("subString1: "+subString1);  //subString1: urav

        // Start and End index - Note - end index is exclusive
        String subString2 = name.substring(1,4);
        System.out.println("subString2: "+subString2);  //subString2: aur

    //6. Strings are immutable

    //   Different identity hash codes indicate different objects.
    //   Since a new object was created instead of modifying the existing one, String is immutable.

        System.out.println("Before: " + System.identityHashCode(name));  //Before: 495053715
        name = name.concat(" Kumar");
        System.out.println("After : " + System.identityHashCode(name));  //After : 1922154895


    //7. String equality

    //   i. == -> only detemines if two strings are stored at same location ("Gaurav" == name -> true)
    //         But not always
    //  ii. equals -> use equals to check the content

        boolean check1 = name.substring(0,name.indexOf("r")) == "Gau";      //check1: false
        System.out.println("check1: "+check1);
        boolean check2 = name.substring(0,name.indexOf("r")).equals("Gau"); //check2: true
        System.out.println("check2: "+check2);

    //8. Some functions -

    //  i. equalsIgnoreCase

        String name1 = "GAURAV";
        boolean check3 = name.equalsIgnoreCase(name1);
        System.out.println("check3: "+check3);

    // ii. compareTo -> same = 0, if name < name1 = -ve else +ve
        int compareTo = name.compareTo(name1);
        int compareToIgnoreCase = name.compareToIgnoreCase(name1);
        System.out.println("compareTo: "+compareTo);
        System.out.println("compareToIgnoreCase: "+compareToIgnoreCase);

    //iii. isEmpty - checks length() = 0
    //     isBlank - checks length() = 0 OR if the field has whitespaces chars like spaces, tabs, newline
    //     Self understood

    // iv. startsWith(String prefix)
    //     endsWith(String suffix)

    //  v. Strip - remove whitespaces
    //     strip
    //     stripLeading()
    //     stripTrailing()
    //     use these methods over trim as - trim() only identifies ASCII whitespace (e.g., tabs, spaces, newlines ≤ U+0020).

    // vi. replace

        // 1. The baseline text
        String template = "Welcome to {platform}. Learn {topic} on {platform}!";
        System.out.println("Original: "+template); //Original: Welcome to {platform}. Learn {topic} on {platform}!

        // 2. target as a standard String literal
        CharSequence target1 = "{platform}";

        // 3. replacement as a mutable StringBuilder
        CharSequence replacement1 = new StringBuilder("CodeAcademy");

        // First replacement: Swapping "{platform}" with "CodeAcademy"
        // Note: It replaces ALL occurrences of "{platform}" automatically!
        String step1 = template.replace(target1, replacement1);
        System.out.println("Step 1: " + step1); //Step 1: Welcome to CodeAcademy. Learn {topic} on CodeAcademy!

        // 4. target as a standard String variable
        CharSequence target2 = "{topic}";

        // 5. replacement as a thread-safe StringBuffer
        CharSequence replacement2 = new StringBuffer("Java Programming");

        // Second replacement: Swapping "{topic}" with "Java Programming"
        String finalResult = step1.replace(target2, replacement2);
        System.out.println("Final : " + finalResult); //Final : Welcome to CodeAcademy. Learn Java Programming on CodeAcademy!

    }
}
