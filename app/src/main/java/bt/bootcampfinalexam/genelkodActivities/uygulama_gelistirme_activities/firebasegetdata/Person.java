package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.firebasegetdata;

/**
 * Created by ${Burhan} on 3.07.2017.
 * burhantoprakman@gmail.com
 */

public class Person {
    private String name;
    private String address;

    public Person() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

