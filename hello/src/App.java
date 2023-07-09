public class App {
    public static void main(String[] args) throws Exception {
        /*
         * This is a multi-line comment. 
         */
        System.out.println("Hello, World!");
        // Hellow world. This is a single line comment.

        // ----------------------
        // Data Types - Primitive
        // ----------------------

        // Boolean
        boolean javaIsCool = false;
        javaIsCool = true;
        System.out.println(javaIsCool); // Outputs `true`

        // Integer
        byte lilNum = 127; // typically don't use
        short smallNum = 32_767; // again, just typically use int really
        int regNum = 123456; // default type
        long bigBoy = 123456789L; // needs the `L` on the end

        // Decimals!
        float smallDecimal = 5.75f; // needs the `f`, don't use as not precise
        double regDecimal = 42.42d; // Default, don't need `d` but just do it. 
        /*
         * Precision is typically more important than space, especially with 
         * computers today. So stick with `double` unless very specific reason.
         * float has about 6-7 decimal digits of precision.
         * `double` gets about 15 digits. 
         */

        // Character
        char gradeChar = 'A';
        char gradeUnicode = '\u0041';
        char gradeDigit = 65;

        // Used Unicode character table: https://www.rapidtables.com/code/text/unicode-characters.html

        System.out.println(gradeChar + " = " + gradeUnicode + " = " + gradeDigit);

        // ----------------------
        // Data Types - Complex
        // ----------------------

        // String
        String mess = "Hi";
        System.out.println(mess);
    }
}
