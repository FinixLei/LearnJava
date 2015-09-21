package com.finix.mvnbook.hellomaven;

public class HelloMaven {
    public String sayHello() {
        return "Hello, Maven!";
    }
    
    public static void main(String[] argv) {
        System.out.println(new HelloMaven().sayHello());
    }
}

/*
$ mvn clean compile
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
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.138 s
[INFO] Finished at: 2015-09-21T20:34:33+08:00
[INFO] Final Memory: 13M/241M
[INFO] ------------------------------------------------------------------------

*/

/*
    clean means clean the folder "target/", 
    compile means compiling the main code, from the output above, it can be seen that:
    1) execute clean:clean task, i.e. delete the content of the folder 'target/'
    2) execute resource:resource task, but in this case, there is no resource
    3) execute compiler:compile task, which is to build the class files to target/classes folder
*/