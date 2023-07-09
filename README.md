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

It is important to note that the name of your main class in the file, the entry point, must match the name of the file. And that class should have a method called `main()` to run. 

Declare variables starting with their data type. 

Concatenate with the `+` operator. 