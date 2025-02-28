# 1.4: Types of Errors

Let's first discuss `Syntax`. Every programming language has its syntax - a set of rules that dictate what words can be used and how to use them correctly to write 'legal' code.

**Example of a syntax rule**: Identifiers cannot start with a number or most symbols. For instance, `1num` is not legal!

The `Semantics` of a programming language defines what happens when the expression is executed. In natural language, a word can have multiple meanings, but not in programming languages! The computer won't know which command to execute if there is ambiguity.

### There are 3 Types of Errors:

We can encounter each type of error at different stages in the program development process:
1. **Compile-time error**
2. **Run-time error**
3. **Logical error**

#### Compile-time Error

After writing our Java source code, the next step is to compile it into bytecode. The compiler checks if the source code's `syntax` is well-written and if it is `semantically` possible. If not, the compiler produces an error called a compiling error because it was found during compilation. When a compile-time error occurs, **no bytecode is created**!

```java
// Example of a compiling error
public class SayHello {
    public static void main(String[] args) {
        System.out.println("hello") // What is missing? ;
    }
}
```

#### Run-time Error

After compiling our source code, we can run it. If the program crashes or ends unnaturally during this stage, we have encountered a `run-time error`.

```java
// Example of a run-time error
/* Everything seems syntactically and semantically correct, but there are other rules, like no dividing by zero, that come from mathematics */
public class SayHello {
    public static void main(String[] args) {
        System.out.println(100 / 0); // Dividing by zero
    }
}
```

#### Logical Error (Target Error)

This type of error occurs when the code has been compiled, and the program runs, but the result is incorrect. These errors are very hard to spot.

```java
// Logical error
/* This program's goal is to calculate the sum of 2 and 3 */
public class SayHello {
    public static void main(String[] args) {
        System.out.println(2 + 4); // Incorrect sum
    }
}
```

### Recap

- **Syntax Errors**: Detected during compilation when the code does not follow the language's syntax rules.
- **Run-time Errors**: Occur during the program's execution, causing it to crash or behave unexpectedly.
- **Logical Errors**: Occur when the program runs successfully but produces incorrect results due to flaws in the logic.

Each type of error requires different approaches to identify and fix, and understanding these can significantly improve debugging and development processes.
