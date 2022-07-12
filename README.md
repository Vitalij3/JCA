## How to use
- add dependency to your project
- create instance ClashApi
- use all methods!

## Downloads
![maven-central](https://img.shields.io/maven-central/v/io.github.vitalij3/Java-Clash-API?color=yellow)
![GitHub last commit](https://img.shields.io/github/last-commit/Vitalij3/JCA)
![GitHub](https://img.shields.io/github/license/Vitalij3/JCA)


Due to my lack of knowledge, my maven repository began to feel bad, and there are many versions hanging on it, which are difficult to call versions because nothing has changed in them. Starting with version 1.3.1 you can safely use my library. From all this I want to conclude that I will try not to create problems for myself and improve the quality of my development :)

Maven:
```xml
<dependency>
    <groupId>io.github.vitalij3</groupId>
    <artifactId>Java-Clash-API</artifactId>
    <version>VERSION</version>
</dependency>
```
Gradle:
```groovy
implementation 'io.github.vitalij3:Java-Clash-API:VERSION'
```

## Example code

```java
package com.example;

import io.github.vitalij3.JCA.ClashApi;
import io.github.vitalij3.JCA.models.locations.Location;

public class Demo {
    public static void main(String[] args) {

        // creating instance
        ClashApi clashApi = new ClashApi("token");

        // getting locations list
        Location.Item location = clashApi.getLocations().get(1);

        // getting player rankings list and writing in console
        clashApi.getRankingsPlayersVersus(location.id).forEach(player -> System.out.println(player.name + " -> " + player.tag));
    }
}
```