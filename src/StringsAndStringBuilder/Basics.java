package StringsAndStringBuilder;

public class Basics {
    //Strings are immtable
    //String pool where many refrence variables point to the same object
    //any change you want to make in object new object is created and varibale point to new object then
    public static void compare() {
        String a = "Utkarsh";
        String b = "Utkarsh";
        System.out.println(a == b);//can also user equals method
        String name1 = new String("Utkarsh");
        String name2 = new String("Utkarsh");
        System.out.println(name1 == name2);
        System.out.println(name1.equals((name2)));

    }
    public static void stringFormating(){
        float a=453.12374f;
        System.out.printf("formatted number is %2f",a);
    }
    public static void sb(){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<26;i++){
            char ch=(char)('a'+i);
            builder.append(ch);
        }
    }
}
