ObjectConverter
===============

## Build status
[![Build Status](https://buildhive.cloudbees.com/job/michalkolodziejski/job/ObjectConverter/badge/icon)](https://buildhive.cloudbees.com/job/michalkolodziejski/job/ObjectConverter/)

##Description
`ObjectConverter` is an utility class that gives you the ability to convert (cast) between objects.

***Note: *** current version converts only from `String` objects.

### Predefined converters

***From String to:***
```Java
    Boolean
	Byte
	Double
	Float
	Integer
	Long
	Short
```

### Using converter
#### 'casting' String to Boolean
```Java
String input = "true";
Boolean output = ObjectConverter.convert(input, Integer.class);
System.out.println(output); // true
```

#### 'casting' String to Byte
```Java
String input = "127";
Byte output = ObjectConverter.convert(input, Byte.class);
System.out.println(output); // 127
```

#### 'casting' String to Double
```Java
String input = "0.0";
Double output = ObjectConverter.convert(input, Double.class);
System.out.println(output); // 0
```

#### 'casting' String to Float
```Java
String input = "0.0";
Float output = ObjectConverter.convert(input, Float.class);
System.out.println(output); // 0
```

#### 'casting' String to Integer
```Java
String input = "2147483647";
Integer output = ObjectConverter.convert(input, Integer.class);
System.out.println(output); // 2147483647
```

#### 'casting' String to Long
```Java
String input = "9223372036854775807";
Long output = ObjectConverter.convert(input, Long.class);
System.out.println(output); // 9223372036854775807
```

#### 'casting' String to Short
```Java
String input = "32767";
Short output = ObjectConverter.convert(input, Short.class);
System.out.println(output); // 32767
```

##Compile
You need JDK 1.7 and Maven to compile the project.
```shell
    mvn clean
    mvn compile
```

### Extending functionality
You can easily extend functionality with your own converter using method:
```Java
public static void registerConverter(Class type, ConvertFunction<String, ?> closure)
```

***Example for registering converter from String to Date***

```Java
ObjectConverter.registerConverter(Date.class, new ConvertFunction<String, Date>() {
	@Override
    public Date apply(String value) throws ParseException {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.parse(value);
    }
});
```

## Credits
It all started by 'scratching own itch' - universal solution created solely for my own consumption. Then I've decided to share it with JAVA community.

## History

2014-05-03

* Initial version.

## Problems?

[Submit an issue](https://github.com/michalkolodziejski/ObjectConverter/issues).