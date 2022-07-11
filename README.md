## How to use
- add dependency to your project
- create instance ClashApi
- use all methods!

## Downloads
Maven:
```xml
<dependency>
    <groupId>io.github.vitalij3</groupId>
    <artifactId>Java-Clash-API</artifactId>
    <version>1.2.3</version>
</dependency>
```
Gradle:
```groovy
implementation 'io.github.vitalij3:Java-Clash-API:1.2.3'
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
        clashApi.getRankingsPlayersVersus(location.id).forEach(player -> {
            System.out.println(player.name + " -> " + player.tag);
        });
    }
}
```