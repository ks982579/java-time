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

