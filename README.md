# LOTR SDK
### The One SDK

### How to get it

This artifact will be deployed to Maven Central.  Coordinates:

```
<dependency>
    <groupId>com.liblab</groupId>
    <artifactId>lotrSDK</artifactId>
    <version>${project.version}</version> <!-- current '0.0.1-SNAPSHOT' -->
</dependency>
```

### How to build It

To build it, simply run `mvn clean install`

### How to use It

Add the sdk to your project as a Maven dependency and then invoke methods on `com.liblab.lotrsdk.LotrApp` to interact with [LOTR](https://github.com/gitfrosh/lotr-api) APIs.  
For e.g.

```
public class SampleClass {

    public static void main(String[] args) {
        com.liblab.lotrsdk.LotrApp lotrApp = new com.liblab.lotrsdk.LotrApp("RQyh4TvpOomu-MUHqMe1").build();
        List<Movie> movies = lotrApp.listAllMovies();
    }
}
```
### Pagination

```
For pagination, we added a PageCriteria class which can be used to specfict page, limit and offset values. 

It has the following default values and is used for all Movie API calls

limit=10
page=1
offset=0

```

### Filtering

```
For attribute filtering, we added MovieCriteria which can be used to specify attributes, symbols and values  
It has the following default values and is used for all Movie API calls. 

Filtering is optional
```
