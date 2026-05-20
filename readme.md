/Users/harshit/Library/Android/sdk
This package has installed:
* Node.js v24.15.0 to /usr/local/bin/node
* npm v11.12.1 to /usr/local/bin/npm
  Make sure that /usr/local/bin is in your $PATH.

Last login: Tue May 19 23:27:48 on ttys000
harshit@Harshits-MacBook-Air ~ % ~/.zshrc
zsh: permission denied: /Users/harshit/.zshrc
harshit@Harshits-MacBook-Air ~ % nano ~/.zshrc
harshit@Harshits-MacBook-Air ~ % source ~/.zshrc
harshit@Harshits-MacBook-Air ~ % java -version
echo $JAVA_HOME
openjdk version "25.0.2" 2026-01-20
OpenJDK Runtime Environment (build 25.0.2+10-69)
OpenJDK 64-Bit Server VM (build 25.0.2+10-69, mixed mode, sharing)
/Users/harshit/Library/Java/JavaVirtualMachines/openjdk-25.0.2/Contents/Home
harshit@Harshits-MacBook-Air ~ % adb version
echo $ANDROID_HOME
Android Debug Bridge version 1.0.41
Version 37.0.0-14910828
Installed as /Users/harshit/Library/Android/sdk/platform-tools/adb
Running on Darwin 24.5.0 (arm64)
/Users/harshit/Library/Android/sdk
harshit@Harshits-MacBook-Air ~ % node -v
npm -v
v24.15.0
11.12.1
harshit@Harshits-MacBook-Air ~ % adb version
echo $ANDROID_HOME
Android Debug Bridge version 1.0.41
Version 37.0.0-14910828
Installed as /Users/harshit/Library/Android/sdk/platform-tools/adb
Running on Darwin 24.5.0 (arm64)
/Users/harshit/Library/Android/sdk
harshit@Harshits-MacBook-Air ~ % java -version
echo $JAVA_HOME
openjdk version "25.0.2" 2026-01-20
OpenJDK Runtime Environment (build 25.0.2+10-69)
OpenJDK 64-Bit Server VM (build 25.0.2+10-69, mixed mode, sharing)
/Users/harshit/Library/Java/JavaVirtualMachines/openjdk-25.0.2/Contents/Home
harshit@Harshits-MacBook-Air ~ % adb version
echo $ANDROID_HOME
Android Debug Bridge version 1.0.41
Version 37.0.0-14910828
Installed as /Users/harshit/Library/Android/sdk/platform-tools/adb
Running on Darwin 24.5.0 (arm64)
/Users/harshit/Library/Android/sdk
harshit@Harshits-MacBook-Air ~ % node -v
npm -v
v24.15.0
11.12.1
harshit@Harshits-MacBook-Air ~ % echo $JAVA_HOME
echo $ANDROID_HOME
echo $PATH
/Users/harshit/Library/Java/JavaVirtualMachines/openjdk-25.0.2/Contents/Home
/Users/harshit/Library/Android/sdk
/opt/homebrew/bin:/Users/harshit/Library/Java/JavaVirtualMachines/openjdk-25.0.2/Contents/Home/bin:/opt/homebrew/Cellar/openjdk@17/17.0.16/libexec/openjdk.jdk/Contents/Home/bin:/Users/harshit/Downloads/apache-maven-3.9.11/bin:/opt/homebrew/Cellar/openjdk@17/17.0.16/libexec/openjdk.jdk/Contents/Home/bin:/Users/harshit/Downloads/apache-maven-3.9.11/bin:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/appleinternal/bin:/Users/harshit/Library/Android/sdk/platform-tools:/Users/harshit/Library/Android/sdk/emulator:/Users/harshit/Library/Android/sdk/cmdline-tools/latest/bin
harshit@Harshits-MacBook-Air ~ % java -version
adb --version
emulator -version
openjdk version "25.0.2" 2026-01-20
OpenJDK Runtime Environment (build 25.0.2+10-69)
OpenJDK 64-Bit Server VM (build 25.0.2+10-69, mixed mode, sharing)
Android Debug Bridge version 1.0.41
Version 37.0.0-14910828
Installed as /Users/harshit/Library/Android/sdk/platform-tools/adb
Running on Darwin 24.5.0 (arm64)
INFO         | Android emulator version 36.5.11.0 (build_id 15261927) (CL:N/A)
INFO         | Graphics backend: gfxstream
Android emulator version 36.5.11.0 (build_id 15261927) (CL:N/A)
Copyright (C) 2006-2024 The Android Open Source Project and many others.
This program is a derivative of the QEMU CPU emulator (www.qemu.org).

This software is licensed under the terms of the GNU General Public
License version 2, as published by the Free Software Foundation, and
may be copied, distributed, and modified under those terms.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

harshit@Harshits-MacBook-Air ~ % which emulator
/Users/harshit/Library/Android/sdk/emulator/emulator
harshit@Harshits-MacBook-Air ~ %


 <dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>10.1.1</version>
    <scope>compile</scope>
    </dependency>
    <!-- Source: https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.12.0</version>
    <scope>test</scope>
</dependency>

appium driver install uiautomator2
