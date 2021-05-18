# Tomcat Project:

## Run Config
### tomcat Server:
Point tomcat server to the root directory of the tomcat software. ex: `apache-tomcat-9.0.46`
### Deployment Dir:
Set deployment directory to the working dorectory of your app. This should probably be the directory containing the directory `WEB-INF/` is located.
### Context Path:
This will be the first part of your URL after the port. ex: `http://localhost:8080/CONTEXTPATH/...`

## Project Requirements
### Listener:
In order for the tomcat web server to execute servlets, we need a listener. 
This must be listed in the web.xml file with the `<listener>` tag. 
This project's listener is described:
```
    <listener>
        <listener-class>servlet.DependencyLoaderListener</listener-class>
    </listener>
```

The listener itself implements `javax.servlet.ServletContextListener` and must override `contextInitialized` and `contextDestroyed`.
The listener for this project is:
```
public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
```

## Mapping Servlets
### Describe the servlet
Each servlet must be described with a name and class. ex: 
```
    <servlet>
        <servlet-name>pingServlet</servlet-name>
        <servlet-class>servlet.PingServlet</servlet-class>
    </servlet>
```

And each servlet must map a URL to the name. The url-pattern will be what follows the context path. ex: `http://localhost:8080/CONTEXTPATH/URL-PATTERN...`
In the following example the /ping url-pattern maps to the pingServlet, which above points to the PingServlet class. 
```
    <servlet-mapping>
        <servlet-name>pingServlet</servlet-name>
        <url-pattern>/ping</url-pattern>
    </servlet-mapping>
```
HTTP requests sent to this URL will be handled by the "do" methods in PingServlet.  