# 1.3: Compiler vs Interpreter and the Java way

Running a program after it's compiled is fast, and if it's executed by the same system, there is no need to recompile. However, the compiling process is long, complex, and CPU-specific. If we try to execute the compiled program on a system with a different CPU, we will have to recompile it.

**Platform-Bound Languages**: This means that some languages are platform-bound. For example, when compiling a C program, the compiler translates the source code into machine code that the computer uses. If we want to run that program on another type of system, we need to recompile it with the appropriate compiler.

**Interpreter**: An interpreter works differently. It reads the source code line by line and executes each line immediately after reading it, skipping the compilation step. However, this approach has a downside: running the program is slower compared to a compiled program.

**Example**: Python is an interpreted language. When you run a Python script, the interpreter reads and executes the code line by line.

```python
# Python example
print("Hello, world!")
```

Running the above Python code involves the interpreter reading and executing the `print` statement directly, without a prior compilation step.

### The Java Advantage

Java utilizes both methods, compiling and interpreting:
1. **Writing the Source Code**: Write a Java program and save it as `FileName.java`—this is the source code.
2. **Translation to Machine Code**: This process involves two steps:
    1. The Java compiler translates the source code into `bytecode`, creating a file called `FileName.class`.
    2. The interpreter (Java Virtual Machine - JVM) translates the `bytecode` into machine code and executes the program directly.

**Merits and Drawbacks**:
- **Platform Independence**: Java programs are not platform-dependent. We can install a JVM on any system, creating a pipeline between the system's CPU and the `.class` file. The `bytecode` is translated to `machine code` by the JVM, allowing the code to work on any platform with a JVM.
- **Speed Trade-Off**: The addition of `bytecode` introduces another layer between the source code and the target code, making the language slower. However, the speed loss is considered acceptable for the flexibility gained.

Ultimately, it’s a balance between speed and flexibility. Bytecode is close to machine code, and Java designers concluded that the speed loss is worth the flexibility it provides.

