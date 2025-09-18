package StringBuffer;

public class Main {
    public static void main(String[] args) {
        // Constructors
        StringBuffer sb1 = new StringBuffer();               // Empty buffer (capacity 16)
        StringBuffer sb2 = new StringBuffer(50);             // Empty buffer with capacity 50
        StringBuffer sb3 = new StringBuffer("Hello");        // Initialized with "Hello"

        // Methods & Usage
        sb3.append(" World");                                // Hello World
        System.out.println("After append: " + sb3);

        sb3.insert(6, "Java ");                              // Hello Java World
        System.out.println("After insert: " + sb3);

        sb3.replace(6, 10, "Beautiful");                     // Hello Beautiful World
        System.out.println("After replace: " + sb3);

        sb3.delete(6, 16);                                   // Hello World
        System.out.println("After delete: " + sb3);

        sb3.reverse();                                       // dlroW olleH
        System.out.println("After reverse: " + sb3);

        sb3.reverse();                                       // Hello World
        sb3.setCharAt(0, 'h');                               // hello World
        System.out.println("After setCharAt: " + sb3);

        System.out.println("Length: " + sb3.length());       // 11
        System.out.println("Capacity: " + sb3.capacity());   // might be > 16

        sb3.ensureCapacity(100);                             // Increase capacity if needed
        System.out.println("Capacity after ensure: " + sb3.capacity());

        sb3.trimToSize();                                    // Match capacity to length
        System.out.println("Capacity after trim: " + sb3.capacity());

        String sub = sb3.substring(0, 5);                    // "hello"
        System.out.println("Substring: " + sub);
    }
}
