package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Fundamental {

    public static void main(String[] args) throws CloneNotSupportedException {

        Fundamental fundamental = new Fundamental();
        fundamental.practiceObjectCloning();
    }

    public static void practiceStream(){

        List<String> words = new ArrayList<>(Arrays.asList(new String[]{"Success", "Kannan", "Nation", "City","Nepoleon"}));

        List<String> wordsStartingWithN = words.stream().
                map(word->word.toUpperCase()).
                filter(word->word.startsWith("N")).
                collect(Collectors.toList());
        wordsStartingWithN.stream().
                forEach(word->System.out.println(word));
        words.stream().forEach(word->System.out.println(word));
    }

    public void practiceFileHandling() throws FileNotFoundException{

    /*File Reading
       java.io.fle - package depricated from 1.7
       use java.nio.file
    *  BufferedReader -
          reading large/text data efficiently,when reading lines of text.
       FileInputStream -
          reading binary data or when fine-grained control over byte-level data is required
          Ex-Image file byte by byte read..
    **/
        //Read File: example in Exception function.
        //Write on file.
        String content = "Content";
        try(FileOutputStream outputStream = new FileOutputStream("Targetfilepath")){
            byte[] bytes = content.getBytes();
            outputStream.write(bytes);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void practiceExceptionHandling(){
        /*
            keywords
            try : critical code can surrounded by try block.
            catch : follow with try block,it catches exceptions.
            finally : execute necessary lines,eventhouth exception cought or not.
            throw : it throw the exception when occur.
            throws : declared exceptions in method signature,means that the function may throw an exception.

            we can use throw/throws independently.
         */

        //Try with resource.(necessary final opeartion also handled here,Finally not needed)
        try(FileInputStream inputStream = new FileInputStream("file.txt")){
            int val;
            while((val = inputStream.read()) != -1){
                System.out.print((char)val);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //User defined Exception :
        /* Careate New Custom exception class extend Exceptio for Checked exceptio, extend Runtime exception
        * for define unchecked exception. pass message in the constructors.*/

    }

    public void practiceAccessModifiers(){
        /*
        * public : accesed by other package classes also.
        * protected : same package classes and child classes from other packages.
        * default : Accessible by same package classes only.
        * private : accessible inside the declared class.
        * */
    }

    public static void practiceOperators(){

        /*
        * Arithmetic Operator :
        * (+,-,*,/)
        *
        * Unary Operator : (That's opearate on an Single operand.)
        * ( -, ++, --, !, ~)
        *
        *Assignment operator :
        * ( +=, -=, *=, /=, %=)
        *
        * Bitwise operators :
        * (|,&,!, >>, <<)
        *
        * Relational Operators :
        * (<, >, ==, !=, <=, >=)
        *
        * Logical Operator :
        * (&&,||,!)
        *
        * Ternary Operator :
        * var_result = (Condition) ? if true : if false;
        *
        * */

        //Bitwise Right shift operator(>>).
        int a = 256;
        int c = a>>4;                        //16
        int b = (int) (256/Math.pow(2,4));   //16
        System.out.println("Bitwise right shift : "+c+" : "+b);

        //Bitwise Left shift operator(<<).
        int k = 5;
        int l = k<<2;                  //20
        int m = k*(int)Math.pow(2,2);  //20
        System.out.println("Bitwise Left shift : "+l+" : "+m);
    }


    public static void stringJoiner(){

        List<String> names = Arrays.asList(new String[]{"kd","jd","jk","sk"});

        StringJoiner stringJoiner = new StringJoiner(":");
        stringJoiner.add(names.get(0));
        stringJoiner.add(names.get(1));

        StringJoiner stringJoiner2 = new StringJoiner("-");
        stringJoiner2.add(names.get(2));
        stringJoiner2.add(names.get(3));

        stringJoiner.merge(stringJoiner2);
        System.out.println(stringJoiner.toString());
    }


    public static void practiceStringTokenizer() {

        String token_string = "Hellow : world";

        StringTokenizer tokenizer = new StringTokenizer(token_string, ":");
        while (tokenizer.hasMoreTokens())
            System.out.println(tokenizer.nextToken());

        //Consider delimiter as one token.
        StringTokenizer tokenizer_include_delim = new StringTokenizer(token_string, ":", true);
        StringTokenizer tokenizer_without_delim = new StringTokenizer(token_string, ":", false);
    }

    /*Note: when to use which one, do refer below as follows String|StringBuilder|StringBuffer:
    Objects of String are immutable, and objects of StringBuffer and StringBuilder are mutable.
    StringBuffer and StringBuilder are similar, but
    StringBuilder is faster and preferred over StringBuffer for the single-threaded program.
    If thread safety is needed, then StringBuffer is used.*/

    public static void practiceStringBuilder(){
        /*Default capacity is -> 16
         * Grow like -> (existing_capacity * 2)+2 => 34
         * check capacity by in-build function,
         *   sb.capacity();
         * StringBuffer is Not-Thread safe,Mutable. Efficient than StringBuffer
         * */
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder(20);
        StringBuilder sb2 = new StringBuilder("world");

        sb2.insert(0,"world");
        sb2.reverse();
        System.out.println(sb1.capacity());
        sb1.append("abcedefghijklmnopqrstuvwxyz");
        System.out.println(sb1.capacity());
    }


    public static void practiceStringBuffer(){

        /*Default capacity is -> 16
         * Grow like -> (existing_capacity * 2)+2 => 34
         * check capacity by in-build function,
         *   sb.capacity();
         * StringBuffer is Thread safe,Mutable/Functions were synchronized,less performance compare to StringBuilder.
         * */

        /*Constructors of StringBuffer*/
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer(20);
        StringBuffer sb2 = new StringBuffer("Hellow");
        sb1.append("world");
        sb1.reverse();
        sb1.replace(1,3,"oll");  //end is exclusive.
    }

    public static void practiceString() {
        /*
            String data -> Immutable -> Constant -> String class is defined with final keyword.
            Note : There're 19 inbuild functions present in a java string object.
        */

        //1. String Literal
        String s = "Suresh";

        /*2. Using new keyword
            1. Creates object in Heap memory.
            2. the string "Suresh" placed in the string pool also.
            3. variable refers object in the heap memory.
        */
        String ss = new String("Suresh");
        System.out.println(s.hashCode()+""+ss.hashCode()+" : "+s.equals(ss));  //Both objects were same.


        /*  Encoding and Decoding:
            * byte[] to string - Decoding
            * String to byte[] - Encoding
            Use case : File transmission over network.
        */
        byte[] barr = {23,45,67,86};

        //Decoding
        String byteString_ASCII = new String(barr, StandardCharsets.US_ASCII);
        System.out.println(byteString_ASCII);   //Converted as ASCII string data.
        String byteString_UTF_8 = new String(barr, StandardCharsets.UTF_8);
        System.out.println(byteString_UTF_8);   //Converted as UTF_8 string data.
        String byteString_UTF_16 = new String(barr, StandardCharsets.UTF_16);
        System.out.println(byteString_UTF_16);   //Converted as UTF_16 string data.

        //Encoding
        byte[] string_to_bytes = byteString_ASCII.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(string_to_bytes));
        byte[] string_to_bytes1 = byteString_ASCII.getBytes(StandardCharsets.UTF_16);
        System.out.println(Arrays.toString(string_to_bytes1));
        byte[] string_to_bytes2 = byteString_ASCII.getBytes(StandardCharsets.US_ASCII);
        System.out.println(Arrays.toString(string_to_bytes2));


    }

        class Student implements Cloneable{
            private int age = 10;
            private String name;
            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }
    public void practiceObjectCloning() throws CloneNotSupportedException {

        Student s = new Student();
        
        //class should implements Clonable to call clone function.
        Student clonnedStudent = (Student)s.clone();
        System.out.println(clonnedStudent.equals(s));  //Both are not equal.

        System.out.println(clonnedStudent.toString());
        System.out.println(clonnedStudent.age+" "+s.age);
        s.age = 99;
        System.out.println(clonnedStudent.age+" "+s.age);

        /*Object class is parent class of all classes directly or indirectly
        * Functions : equals | toString| clone| wait| notify| notifyAlll| finalize| */

        /*
            *Whether it's shallow copy or deep copy - result will be two distinct onjects.
            * Shallow Copy:
            * In a shallow copy, the cloned object contains copies of the original object's fields.
            * As a result, both the original object and the cloned object will share references to the same objects.
            * Any modifications made to the shared objects through one reference will be visible through the other reference.

            * Deep copy :
            * Cloned object will have it's own reference object cloned itself.
            * modifications made to the objects referenced by one object will not affect the objects referenced by the other object.
         */
    }

    public void practiceTypeCastingAndBoxing(){

        String str_int = "1000";
        //Object Conversion.
        Integer value_obj = Integer.valueOf(str_int);
        String string_obj = String.valueOf(200.3);

        //Primitive conversion.
        int primitiveValue = Integer.parseInt(str_int);

        //Implicit type casting(Widening).  [Bigger data type <-  smaller type] no data loss.
        int smallerType = 100;
        long bigger = smallerType;

        //Explicit type casting(Narrowing)  [smaller type  <- (smaller type)Bigger data type]  leads to data loss
        int again_to_smaller = (int) bigger;

        //Convertion to any type.
        int k = value_obj.intValue();
        int l = (int)value_obj.doubleValue();   //Explicit type casting.
        float ff = value_obj.floatValue();

        //Boxing_Unboxing
        Integer integer_obj = 10;       //AutoBoxing
        int int_primitive = integer_obj; //Auto_unboxing.
    }


    public static void practiceDataType(){

        /*
        byte : 8 bit signed intger (-128 to 127)   1 byte*/
        byte b = 127;
        byte b2 = -128;

        /*
        short : 16 bit signed intger (-32768 to 32767)   2 bytes*/
        short s = -32768;
        short s2 = 32767;

        /*
        int : 32 bit signed intger (-2^31 to 2^31-1)   4 bytes */
        int i =  2147483647;
        int i2 = -214748648;

        /*
        long : 64 bit signed integer (-2^63 to 2^63-1) 8 bytes */
        long l = 9223372036854775807l;
        long l2 = -9223372036854775808l;

        /*
        float : 32 bit floating point number | 4 bytes | Range: Approximately ±3.40282347 x 10^38 | 7 deciaml point digits precision */
        float f = 2.1234567f;
        float f2 = -2.1234567f;
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        /*
        double : 64 bit floating point number | 8 bytes | Range: Approximately ±1.7976931348623157 x 10^308 | 15 deciaml point digits precision */
        double d = 2.123456789101112;
        double d2 = -2.1234567891012;
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        /*
         char : 16 bit Unicode character | 2 bytes | \u0000 to \uffff */
         char ch = '\u0000';
         char ch2 = '\uffff';
        System.out.println("Char min: "+ch);
        System.out.println("Char max: "+ch2);

        /*
         boolean : true / false | 1bit */
         boolean bool = true;
         boolean bool2 = false;
    }
}
