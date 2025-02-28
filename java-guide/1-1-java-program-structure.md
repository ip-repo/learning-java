# 1.1: Java Program Basic Structure
In Java, every public class must have the same name as the file it is in. This is a requirement by the Java compiler to ensure proper organization and management of classes and files. If the class name and file name do not match, `the compiler will throw an error`.

```java
/**
 * SayHello.java
 * A basic Java program that says 'hello mate'.
 * 
 * This class demonstrates the structure of a simple Java program,
 * including the use of different types of comments.
 */
public class SayHello {
    public static void main(String[] args){
        /* This is a
         * long comment
         */
        System.out.println("Hello world"); // Inline comment
    }
} // End of class
```

### Explanation:

- **Java is object-oriented**: Everything we write should be within a class. `SayHello` is the class.
- **The `main` function**: To activate the `main` function, we have to use a class.
- **Execution**: When a Java program is executed, the JVM looks for the entry point, which is the `main` method.
- **Printing a message**: In this case, the main method simply prints a message to the standard output (`std`).
- **Classes and methods**: `System` is also a class, and we use its variable `out` to execute a method called `println`.
- **Documentation**: The comments at the start of the file help us and others understand the code.
- **Comments**:
  - `// Inline comment`: A short comment used for quick notes.
  - `/* Long comment */`: For longer comments that span multiple lines.
  - **API Comments**: These are special comments used to generate documentation automatically. In Java, they begin with `/**` and end with `*/`. For example:
    ```java
    /**
     * This is an API comment.
     * It provides detailed information about the method or class.
     */
    ```

### Key Concepts:

- **Public**: The `public` keyword means that anyone can use the class or method.
- **Private**: The `private` keyword restricts access to the class, method, or variable to within the class itself. This means that the private members are not accessible from outside the class.
- **Protected**: The `protected` keyword allows access to the class, method, or variable within the same package and by subclasses (derived classes). This means that protected members are accessible within the package and by inheritance.
- **Static**: The `static` keyword means that the routine can be executed directly without creating an object.
- **Void**: The `void` keyword indicates that the method does not have a return value.

### Naming Convention:

- **Class Name and File Name**: The class containing the `main` method should be named the same as the Java file (e.g., `SayHello.java`). This is because Java requires that the public class name matches the file name. If they do not match, the Java compiler will throw an error. This convention helps in organizing and managing files and classes in a project, ensuring that each public class has a unique and identifiable source file.

### Private Classes:

In Java, a private class does not need to be named the same as the filename. However, you cannot declare a top-level class as private. Private classes must be inner classes declared within another class. The filename should match the name of the outer class.

Here's a example to illustrate this:

### `PC.java`
```java
public class PC {
    
    private class CPU {
        private String model;
        private int cores;

        public CPU(String model, int cores) {
            this.model = model;
            this.cores = cores;
        }

        public void displaySpecs() {
            System.out.println("CPU Model: " + model);
            System.out.println("Number of Cores: " + cores);
        }
    }

    public void showPCDetails() {
        CPU cpu = new CPU("Intel i7", 8);
        cpu.displaySpecs();
    }

    public static void main(String[] args) {
        PC myPC = new PC();
        myPC.showPCDetails();
    }
}
```

### Explanation:

- The filename is `PC.java`, matching the name of the outer class `PC`.
- The inner class `CPU` is private and does not need to match the filename.
- The `main` method in the `PC` class demonstrates the use of the private inner class `CPU` by creating an instance and calling its method.

## Identifiers

The code snippet above is also constructed of something called identifiers. Identifiers are names that describe other entities (they are not the entities themselves, just a way to describe them).

### Types of Identifiers:

1. **Reserved Words**: The programming language has a set of words that are part of the language. In the example, we have `public`, `class`, `static`, `void`. We cannot use them for other purposes than what Java allows.
2. **Predefined Identifiers**: Words that another programmer has chosen, such as those from a library or built-in classes (e.g., `System`, `out`, `println`). These cannot be repurposed.
3. **User-Defined Identifiers**: Words that we invent, like `PC` and `CPU`. Since we created them, they cannot be used for a different purpose than what we meant.

### What About Spaces and New Lines?
The Java compiler ignores spaces and new lines, which allows us to write Java programs in different styles.

```java
public 
class 
IgnoreSpaces
{ 
public 
static 
void 
main(String[]args)
    {
        System
        .
        out
        .
        println("Java ignores spaces and new lines");
    }
}
```


