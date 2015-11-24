# 转载之言

这篇文章转载自<http://www.blogjava.net/hellxoul/archive/2011/11/30/365181.html/> 但是有一点过时了，因为现在可能log4j 2早已流行了起来，而这篇文章介绍的是log4j 1.2. 不过写得不错，对于简单快速入门来说，还是有意义的。感谢原作者。


# Log4j简介

Log4j有三个主要的组件：Loggers，Appenders和Layouts，可简单理解为日志类别，日志要输出的地方和日志以何种形式输出。综合使用这三个组件可以记录信息的类型和级别，并可以在运行时控制日志输出的样式和位置。

1. 公共类 Logger  
	Logger 负责处理日志记录的大部分操作。

2. 公共接口 Appender  
	Appender 负责控制日志记录操作的输出。

3. 公共抽象类Layout  
	Layout 负责格式化Appender的输出。  


-------------------------------------------

## 1. Logger  

Loggers组件有7个级别:  

* static Level ALL: 打开所有日志记录
* static Level DEBUG
* static Level INFO  
* static Level WARN  
* static Level ERROR  
* static Level FATAL  
* static Level OFF: 关闭所有日志记录

日志记录器（Logger）将只输出那些级别高于或等于它的级别的信息。如果没有设置日志记录器（Logger）的级别，那么它将会继承最近的祖先的级别。因此，如果在包com.foo.bar中创建一个日志记录器（Logger）并且没有设置级别，那它将会继承在包com.foo中创建的日志记录器（Logger）的级别。如果在com.foo中也没有创建日志记录器（Logger）,那么在com.foo.bar中创建的日志记录器（Logger）将继承root日志记录器（Logger）的级别，root日志记录器（Logger）经常被实例化而可用，它的级别为DEBUG。

- 取回root Logger：   
<pre><code>Logger logger = Logger.getRootLogger();
</code></pre>

- 创建一个新的日志记录器：
<pre><code>Logger logger = Logger.getLogger("MyLogger");
</code></pre>

- 根据类名实例化一个静态的全局日志记录器：
<pre><code>static Logger logger = Logger.getLogger(MyClass.class);
</code></pre>

- 设置级别
<pre><code>logger.setLevel((Level)Level.INFO);
</code></pre>

---------------------------------------

## 2. Appender

1. ConsoleAppender:  
   使用用户指定的Layout输出日志事件到System.out或System.err

2. FileAppender:  
   把日志写入文件

3. DailyRollingFileAppender (extends FileAppender):  
   多个日志文件以一个用户指定的频率循环记录

4. RollingFileAppender (extends FileAppender):  
   多个日志文件以一个指定容量循环记录

5. WriterAppender：  
   根据用户的选择，把日志写到Writer或OutputStream

6. SMTPAppender：  
   当特定的日志发生时，发送一封电子邮件

7. SocketAppender：  
   给远程日志服务器发送日志事件（LoggingEvent）对象

8. SocketHubAppender：  
   给远程日志服务器群组发送日志事件（LoggingEvent）对象

9. SyslogAppender：  
   给远程异步日志记录的后台守护程序（Daemon）发送消息

10. TelnetAppender：  
    一个专用于向只读网络socket发送消息的Appender

另外，还可以自己实现Appender接口，以创建以自己方式进行日志输出的Appender。
<br>

### 2.1 使用ConsoleAppender

<pre><code>ConcoleAppender appender = new ConsoleAppender(new PatternLayout());
</code></pre>

以上代码创建了一个ConcoleAppender, 它具有一个默认的PatternLayout。这个默认的PatternLayout使用了默认的System.out的输出。
<br>

### 2.2 使用FileAppender

<pre><code>FileAppender appender = null;
try {
    appender = new FileAppender(new PatternLayout(), "file name");
} catch (Exception ex) {
}
</code></pre>

另一个有用的构造函数如下：
<pre><code>// 实例化一个FileAppender并且打开变量"filename"指定的文件。
// 这个构造函数还可以选择是否对指定的文件进行追加的方式输出。如果没有指定值，那么默认的方式就是追加。
FileAppender(Layout layout, String filename, boolean append)
</code></pre>
<br>  
  
### 2.3 使用WriterAppender

<pre><code>WriterAppender appender = null;
try {
    appender = new WriterAppender(new PatternLayout(), new FileOutputStream("file_name"));
} catch (Exception ex) {
}
</code></pre>

这个WriterAppender使用的构造函数带有PatternLayout和OutputStream参数，在以上代码中， FileOutputStream用于向一个文件输出。
<br>

## 3. Layout

Appender必须使用一个与之相连的Layout，它才知道如何格式化它的输出。  
log4j具有3种类型的Layout。  

1. HTMLLayout  
	格式化日志输出为HTML表格

2. PatternLayout
	根据指定的格式来格式化日志输出。如果没有指定任何格式，则使用默认的格式。

3. SimpleLayout
	以一种非常简单的方式格式化输出日志。它打印级别（Level），然后跟着一个破折号，最后才是日志消息。
<br>

## 4. Samples

### 4.1 SimpleLayout & FileAppender

	
	import org.apache.log4j.Level;
	import org.apache.log4j.Logger;
	import org.apache.log4j.SimpleLayout;
	import org.apache.log4j.FileAppender;
	
	public class SimpleAndFile {
	    static Logger logger = Logger.getLogger(SimpleAndFile.class);
	    public static void main(String args[]) {
	        SimpleLayout layout = new SimpleLayout();
	        FileAppender appender = null;
	        try {
	            appender = new FileAppender(layout,"target/test_log4j_SimpleLayout_FileAppender.txt",false);
	        } catch(Exception e) {
	        }
	        
	        logger.addAppender(appender);
	        logger.setLevel((Level) Level.DEBUG);
	        logger.debug("Here is some DEBUG");
	        logger.info("Here is some INFO");
	        logger.warn("Here is some WARN");
	        logger.error("Here is some ERROR");
	        logger.fatal("Here is some FATAL");
	    }
	}

### 4.2 HTMLLayout & WriterAppender

	
	import java.io.*;
	import org.apache.log4j.Level;
	import org.apache.log4j.Logger;
	import org.apache.log4j.HTMLLayout;
	import org.apache.log4j.WriterAppender;

	public class HtmlAndWriter {
	    static Logger logger = Logger.getLogger(HtmlAndWriter.class);
	    public static void main(String args[]) {
	        HTMLLayout layout = new HTMLLayout();
	        WriterAppender appender = null;
	        try {
	            FileOutputStream output = new FileOutputStream("target/test_log4j_HTMLLayout_WriterAppender.html");
	            appender = new WriterAppender(layout,output);
	        } catch(Exception e) {
	        }
	        
	        logger.addAppender(appender);
	        logger.setLevel((Level) Level.DEBUG);
	        logger.debug("Here is some DEBUG");
	        logger.info("Here is some INFO");
	        logger.warn("Here is some WARN");
	        logger.error("Here is some ERROR");
	        logger.fatal("Here is some FATAL");
	    }
	}

### 4.3 PatternLayout & ConsoleWriter

	import org.apache.log4j.Level;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PatternLayout;
	import org.apache.log4j.ConsoleAppender;
	
	public class PatternAndConcole {
	    static Logger logger = Logger.getLogger(PatternAndConcole.class);
	    public static void main(String args[]) {
	        // Note, %n is newline
	        String pattern = "Milliseconds since program start: %r %n";
	        pattern += "Classname of caller: %C %n";
	        pattern += "Date in ISO8601 format: %d{ISO8601} %n";
	        pattern += "Location of log event: %l %n";
	        pattern += "Message: %m %n %n";
	        PatternLayout layout = new PatternLayout(pattern);
	        
	        ConsoleAppender appender = new ConsoleAppender(layout);
	        logger.addAppender(appender);
	        logger.setLevel((Level) Level.DEBUG);
	        logger.debug("Here is some DEBUG");
	        logger.info("Here is some INFO");
	        logger.warn("Here is some WARN");
	        logger.error("Here is some ERROR");
	        logger.fatal("Here is some FATAL");
	    }
	}
	
## 5. Use XML as configuration file 

以下是 "xmllog4jconfig.xml". 

	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
	<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

	    <appender name="appender" class="org.apache.log4j.FileAppender">
	        <param name="File" value="target/PatternAndFileUseXML.log"/>
	        <param name="Append" value="false"/>
	
	        <layout class="org.apache.log4j.PatternLayout">
	            <param name="ConversionPattern" value="%d [%t] %p - %m%n"/>
	        </layout>
	    </appender>
	
	    <root>
	        <priority value ="debug"/>
	        <appender-ref ref="appender"/>
	    </root>

	</log4j:configuration>

从以上的xml文件可以看出，Java代码中会使用PatternLayout和FileAppender，而日志会输出到"target/PatternAndFileUseXML.log"文件中。

以下是Java代码：

	package Test06_log4j1_2;

	import org.apache.log4j.Logger;
	import org.apache.log4j.xml.DOMConfigurator;
	
	public class PatternAndFileUseXML {
	    static Logger logger = Logger.getLogger(PatternAndFileUseXML.class);
	    public static void main(String args[]) {
	        DOMConfigurator.configure("src/Test06_log4j1_2/xmllog4jconfig.xml");
	        logger.debug("Here is some DEBUG");
	        logger.info("Here is some INFO");
	        logger.warn("Here is some WARN");
	        logger.error("Here is some ERROR");
	        logger.fatal("Here is some FATAL");
	    }
	}

