package com.finix.mvnbook.hellomaven;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloMavenTest {
    @Test
    public void testSayHello() {
        HelloMaven helloMaven = new HelloMaven();
        String result = helloMaven.sayHello();
        assertEquals("Hello, Maven!", result);
    }
}

/*
$ mvn clean test
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Hello Project 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ hello-maven ---
[INFO] Deleting C:\Users\leile\Desktop\Hello-Maven\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hello-maven ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\leile\Desktop\Hello-Maven\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ hello-maven ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to C:\Users\leile\Desktop\Hello-Maven\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ hello-maven ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\leile\Desktop\Hello-Maven\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ hello-maven ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to C:\Users\leile\Desktop\Hello-Maven\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ hello-maven ---
[INFO] Surefire report directory: C:\Users\leile\Desktop\Hello-Maven\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.finix.mvnbook.hellomaven.HelloMavenTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.027 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.246 s
[INFO] Finished at: 2015-09-21T21:05:55+08:00
[INFO] Final Memory: 15M/208M
[INFO] ------------------------------------------------------------------------

*/