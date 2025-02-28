## 1.5: Object-Oriented Programming Overview

Java is an object-oriented language.

The Java worldview sees everything as objects. This approach is meant to make programming more natural for humans since it is similar to how we view the world. It mimics the human perspective by:
- Categorizing objects
- Assigning attributes and actions to objects

### Terms of the Object-Oriented Approach

**Object**: Anything that has attributes, methods, and messages.
- **Attributes**: The fields that describe the object (e.g., `Circle.radius`). The attributes describe the `internal state` of the object.
- **Methods**: The actions that can be performed with the object (e.g., `Circle.calculateArea()`).
- **Messages**: How the object communicates with other objects (e.g., a `Car` sending a message to the `FuelSensor`).

**Example: Car**
- **Attributes**: Type = Renault Megane, Category = Family Car, Color = Gray.
- **Methods**: `speedUp()`, `lightsOn()`, `brake()`
- **Messages**: Fuel light on—no more fuel, Seatbelt beep—seatbelt not fastened.

Of course, a car has many other attributes, methods, and messages, but in programming, we address only the parts of reality we want to use in the program. A car is like an abstract object, and each car is different because they have different attributes, but they all share a similar base.

**Class**
- A class is a way to describe all objects of the same type abstractly.
- It is a pattern that allows us to create objects of a certain kind or type (the class type).
- The class doesn't represent a specific object but an abstract definition of a kind of object.
- The class will hold the object's attributes without detailing the values and will have methods that describe the object's behavior.

A class can have many instances, and they can be `different from each other by the value of their attributes but share the same functionality`!

**Example: Car Class**

```java
public class Car {
    private String type;
    private String category;
    private String color;

    public Car(String type, String category, String color) {
        this.type = type;
        this.category = category;
        this.color = color;
    }

    public void speedUp() {
        // Increase the speed of the car
    }

    public void lightsOn() {
        // Turn the car's lights on
    }

    public void brake() {
        // Apply the car's brakes
    }
}
```

**Encapsulation**: An attribute that describes an object as a `"black box"`. The class hides its internal structure from the user and allows interaction only through the class as an `interface`. The object's behavior is well-defined, and we use it because we know exactly what it does without knowing how it does it. For example, a smartphone—one may not know how it works internally but can still use it. We are not allowed to access its internals because we may damage it.

**Inheritance**: A class can be created based on an existing class. For example:
- `Watch` -> Analog Watch or Digital Watch
- `Digital Watch` -> Alarm Clock

This can happen if there is a relationship between the base class and the new class called "is a ..." (e.g., a dog is not a type of fish, but it is a type of wolf). This allows us to avoid rewriting everything each time we want to program something new.

**Example: Inheritance**

```java
public class DigitalWatch extends Watch {
    private boolean hasAlarm;

    public DigitalWatch(boolean hasAlarm) {
        this.hasAlarm = hasAlarm;
    }

    public void setAlarm() {
        // Set the alarm for the digital watch
    }
}
```

**Polymorphism**: The idea that allows us to address different kinds of objects with a hierarchy between them in the same way. For example, by setting a watch to a specific time, other watches will be set as well, regardless of the kind of watch.

**Example: Polymorphism**

```java
public class Watch {
    public void setTime(String time) {
        // Set the time for the watch
    }
}

public class AnalogWatch extends Watch {
    @Override
    public void setTime(String time) {
        // Set the time for the analog watch
    }
}

public class DigitalWatch extends Watch {
    @Override
    public void setTime(String time) {
        // Set the time for the digital watch
    }
}

public class Main {
    public static void main(String[] args) {
        Watch myWatch = new DigitalWatch();
        myWatch.setTime("10:00 AM"); // Sets the time for the digital watch
    }
}
```

