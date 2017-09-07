# How to Contribute
When contributing code to this repository, one must be mindful of code formatting, the separation between API and implementation, as well as documentation. This includes those contributing through pull requests, as well as those who are titled as contributors to the project. 

## Code Formatting
The code format for WeaponsAPI is rather loose, though a minimum expectation is required, that being recommended Oracle programming standards. These include the following:
* Indentation must be made with TAB (not spaces)
* Method and variable naming schemes must follow lowerCamelCase
* Class, Interface and Enum naming schemes must follow UpperCamelCase
* K&R style bracing is recommended

For further explanation on any of the above listed guidelines, please see below.

### Indentation
Many IDEs have the option to indent code with spaces rather than with TAB characters. Ensure that your IDE has this value set to TAB in order to comply with the guidelines. This allows for a much cleaner and more navigable code base for the majority of developers.

### Methods and Variables
According to Oracle's programming standards, the lowerCamelCase syntax declares that the first word of the name must be in lowercase, and all subsequent words in uppercase. The programming style eases the writing syntax when invoking methods and retrieving fields, as well as separates methods from class names. Examples of this syntax are as follows:

**VALID:**

```java
private final String fieldNameHere;

public void methodDeclarationHere() {
	String localVariable = "Hello World!";
}
```

**INVALID:**

```java
private final String FieldNameHERE;

public void MethodDeclarationHere() {
	String LocalVariable = "Hello World!";
}
```

### Classes, Interfaces and Enums
According to Oracle's programming standards, the UpperCamelCase syntax declares that every word of the name must be in uppercase. The programming style clearly differentiates the class from its members and avoids confusion when writing constructors and accessing static methods. Examples of this syntax are as follows:

**VALID:**

```java
public class MyCustomClass {
	
	public static void main(String[] args) {
		// Code
	}
	
}
```

**INVALID:**

```java
public class myCustomClass {
	
	public static void main(String[] args) {
		// Code
	}
	
}
```

### K&R Bracket Style
In Java, there is an ongoing discussion as to what bracket indentation is the preferred method. In WeaponsAPI, the standard to be set is K&R which declares that brackets must be written on the same line as the method or code block in which it belongs. This is preferred over the other more commonly known Allman style bracing. Although some may argue that Allman style is cleaner to read, it adds unnecessary whitespace to the project. Examples of this syntax are as follows:

**VALID:**

```java
public void someMethod() {
	if (true) {
		// Code
	}
	else {
		// Code
	}
}
```

**INVALID:**

```java
public void someMethod()
{
	if (true)
	{
		// Code
	}
	else
	{
		// Code
	}
}
```

## Separation Between API and Implementation
Due to the fact that this project is largely based on the API and its ease of access for developers, there must be a line between the API and the plugin implementation. When contributing code, if the code is intended to be accessed by developers frequently, it should rather be added to the API. However, if said code requires methods or types from the implementation, an interface should be made in the API and the code should implement it. Example:

When creating weapons, developers are required to register their weapons in the WeaponRegistry though it should not be completely visible to the users. Rather, its methods should be visible and the implementation should be separate. To counteract this, an IWeaponRegistry is created in the API which matches the method declarations that should be public. The WeaponRegistry should now implement this interface and override its methods. The API must be aware of this and be retrievable somehow. In order to do this, a method will be created in the IWeaponsAPI interface to retrieve the IWeaponRegistry interface. Because WeaponsAPIPlugin implements IWeaponAPI and the method returns an IWeaponRegistry, the WeaponRegistry (implementation) may be returned directly due to polymorphism.

## Documentation
The formatting of the documentation for this project is rather basic. When creating a method or class, ensure that it is well documented. This includes parameters, returned values, potential alternatives (i.e. @see), and an optional @since annotation indicating when the method or class was created. If a new class was created, include an @author tag identifying the author of the class was. Any method added to that class is assumed to be written by the author of the class. If a new method is added to an existing class with a different author, the option is available to provide an @author annotation on the method declaration. Of course, this is optional and not required, and the commit history / blame will still properly identify the author of the method.

An example of good documentation may be found below:

```java
/**
 * Represents a class that does things
 * 
 * @param <T> a random type parameter that looked cool
 */
public class SomeClass<T> {
	
	/**
	 * Takes two Strings and concatenates their values, ultimately returning a
	 * single String containing both values in the order provided
	 * 
	 * @param firstString the first string to concat
	 * @param secondString the second string to concat
	 * 
	 * @return the resulting concatenated string
	 */
	public String concat(String firstString, String secondString) {
		return firstString + secondString;
	}
	
}
```