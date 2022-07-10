## How to use
- add dependency to your project
- create instance ClashApi
- use all methods!

## Example code

```java
package com.example;

import com.github.salatosik.JCA.ClashApi;
import com.github.salatosik.JCA.models.locations.Location;

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