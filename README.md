# Getting Started. 

```yaml
title: Java 17 for Absolute Beginners
subtitle: Learn the Fundamentals of Java Programming
edition: 2
author: Iuliana Cosmina
publisher: Iuliana Cosmina
year: 2022
distributor: Apress Media, LLC
```

I am working on WSL though VSCode. I know that IntelliJ is very popular, so maybe I'll look into that in the future. 

Firstly, [This LinuxCapable article](https://www.linuxcapable.com/how-to-install-openjdk-17-on-ubuntu-linux/) provides easy commands for installing the
Java Runtime Environment (JRE) and Java Development Kit (JDK), verions 17, on WSL. 

To create projects in VSCode, you'll also need to install The "extensions Java" extension from Microsoft.

I find it hard to direct where the Red Hat Java VS Code extension saves the `*.class` files. 

Additionally, you may want a build tool as most large projects use one. There are a few choices, like Gradle or Maven. Apparently Maven is quite well known. 

```bash
sudo apt install maven
```

Then you need to declare the `M2_HOME` environment variable. I'm reading stackoverflow like:

`.bash_profile`
```bash
export M2_HOME=/usr/share/maven
export PATH=$M2_HOME/bin:$PATH
```

---

Java has **JShell**, which is the Java _Read-Eval-Print-Loop_ (REPL) app. Start up is simple:

```bash
jshell
# or
jshell -v # for Verbose
```

Then, the following are command your can type for more information:

```bash
/help
/list [<name or id> | -all | -start]
/edit <name or id>
/drop <name or id>
/save [-all | -histroy | -start] <file>
/exit [<integer-expression-snippet>]
```

JShell creates "scratch variables" if you explicitly assign a variable name to an output. You can see it in verbose mode. Scratch names have a bash/PHP feel with a `$` prefix. 

Very important and _special_ class is `java.lang.String`. 
---

# How Java Works

Java is very much **class** and **object** oriented. A class mostly contains fields and methods. Object types are organized in packages. Package names must be unique, so they typically start with the internet domain name in revese order. Since Java 5, inside each package a file named `package-info.java` can be created that contains a package declaration, package annotations, package comments, and Javadoc annotations. 

Ok, so in the `scr` directory, if you have package like `com.gitbug.java`, then the "package-info.prjone" file much be located at `./src/com/gitbug/prjone/package-info.java`. But remember these files are only used for documentation and are not mandatory. 

Files with `*.java` extensions are compiled into files with `*.class` extensions, and packaged into one or more **Java Archives** (JARs). If you unpack a JAR, the file structure will be quite similar. 

To run a Java application, a JDK, the dependencies (external JARs), and the application JARs are required. Recommended to look at this article, [What is JAR hell?](https://tech-read.com/2009/01/13/what-is-jar-hell/) 


---

# Writing basic Java

**Access Modifiers** can be used to specify access to classes, used at _top-level_. Or they can specify access to class members, used at _member-level_. 

It is important to note that the name of your main class in the file, the entry point, must match the name of the file. And that class should have a method called `main()` to run. The `main` method is called by the JRE. 

At _top-level_ you can declare class access as `public` or none. Letting it be public means it is visible to all classes in the application. 

Declare variables starting with their data type. 

Concatenate with the `+` operator. 

Like in JavaScript, the `new` keyword is used when _instantiating_ classes as objects. If no access modifier is provided then the class is declared as **default**, or **package-private**. That is, if the class does not have an access modifier specified, then you can only create objects in the same package with it. Scope is limited to the package it is defined in. 

Inside a class, **field** and **method** class members can be defined. At the _member-level_, two additional access modifiers can be applied, `private` and `protected`
+ `public` $\to$ Member can be accessed from everywhere
+ `private` $\to$ Only accessed in package where class containing it is declared
+ `protected` $\to$ Only accessed in package where class containing it is declared or subclass
+ _none_ $\to$ only accessed within its own package

Classes can be declared in the body of another class, called a **nested class**. It has access to all members of the class wrapped around it as I think it lives in the same namespace. However, in the book, the author declares the wrapper class within a method of the nested class to access the properties. 

# Modules

A Java **Module** is "a way to group packages and configure more granulated access to package contents." It's also described by a file called "module-info.java", in the root of the source directory. It must contain:
+ Module name
+ module dependencies
+ package it makes available to other modules
+ serivces it offers
+ services it consumes
+ to what other modules it allows reflections
+ native code
+ resources
+ configuration data

Modules names should be similar to package naming. But ensure it doesn't contain any numbers and clearly defines its purpose. The `module-info.java` file is compiled into a module descriptor `module-info.class`. 

The `java --list-modules` command lists all modules in your local JDK installation. 

A tool called `jlink` helps build smaller runtimes but is not the focus right now. Different modules `require` and `export` other modules. 

# Compiling

There's a `javac` command.

```bash
javac <helloworld.java> -d ./bin
```

The `-d` flag will place the `*.class` files in said directory. Think if it short for "destination". 

Then, to run:

```bash
java --module-path [destination] --module [module name]/[package name]
```

Or more simply for running a class...

```java
java -cp bin App
```

The `import` keyword is also very important. 

# Java Syntax

Java borrowed most of its syntax from C++. 

## Package Declaration

Java files start with the package declaration. The name can contain letters and numbers, separated by dots. Each part should match a directory in the path to the type contained in it. If something is declared in this package, it is referenced with the **qualified package name**, like com.sullivansoftware.javastuff... So, when getting a type, it is called the **fully qualified name** of the Java type, because it uses the qualified package name. 

## Import Section

Use the `import` statement. You can also import `static` variables and `static` methods. Static members do not belong to an object of a type, but to the type itself. You can call static methods and variables without instantiating objects or calling the Class (I believe). 

Sometimes you must use a fully qualified name because of a naming collision, when types are named the same. 

You can also `import static java.lang.Math.*;` to import everything at once. 

## Java Grammer 

Java is **case sensitive**. Also, don't use Java keywords as other names. The curly brackets are **block delimiters**. The semicolon is a **line terminator**. 

## Java Identifiers and Variables

An **identifier** is the name you give an item in Java. And _item_ refers to a class, variable, method, etc... There are some Java coding conventions:
+ identifier cannot be a reserved word
    + In Java 9, the `_` all alone because a reserved word
+ identifiers can be made of letters, numbers, underscore, and dollar sign
+ idenifier cannot begin with a number
+ suggested casing is `camelCase`. Unless class name, then use `PascalCase`

A **variable** has a type and a value, or maybe values. Java has 3 types of variables:
1. **fields**: (aka properties) defined in class bodies, but outside methods. They are not `static`.
2. **local variables**: declared within method bodies, only relevant in that context.
3. **static variables**: declared in class bodies with keyword `static`. 

## Java Comments

There are 3 types of comments:
+ **Single Line Comments**: written as `//`
    + Good for `// TODO: XYZ`, or used within a team
+ **Multiline comments**: written as `/* ... */`
+ **JavaDoc Comments**: written as `/** ... */`
    + These are exported into documentation of a project called JavaDoc API with special tools. 

## Java Types

Simply put, a **class** is a template for creating objects. We **instantiate** a class to create an object. That is, an object is an instance of a class. 
An object implicitly extends class `java.lang.Object` if no other superclass is declared. You could write

```java
package dev.sullivansoftware.example;

public class Sample extends Object {
    ...
}
```

Yes, quick introduction to the `extends` keyword as well. Additionally, note that the `java.lang` package is implicitly imported. 

**Fields**, or **properties**, are like variables defined within a class and for that class. 

You cannot have multiple `public class` classes in one file. But you can create other classes within a "*.java" file, just leave off the `public` keyword. Then, in the `main()` method, you can instantiate that object with the `new` keyword. 

A `constructor` method is automatically generated to setup the class. By default, it just calles `super()`, which invokes `Object` without arguments. As such, any fields in the class schema that are not defined are given default values, typically 0 or `null`. 

Using the `static` keyword can make class variables. These are associated with the class and therefore the same across all instances. Use the `final` keyword as well to make the value immutable, aka a **constant**. 