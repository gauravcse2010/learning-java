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
        String sub = "a";
        int start = name.indexOf(sub);
        int end = name.lastIndexOf(sub);
        System.out.println("start: "+start);            //start: 1
        System.out.println("end: "+end);                //end: 4

    //5. substring
        // Begin Index
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
    }
}
