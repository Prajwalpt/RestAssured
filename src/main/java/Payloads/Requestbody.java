package Payloads;

import java.util.Arrays;

import pojoclass.Addplace;
import pojoclass.location;

public class Requestbody {

	public Addplace postbody() {
		Addplace addPlace = new Addplace();
        addPlace.setAccuracy(50);
        addPlace.setName("Frontline house");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage("French-IN");
        addPlace.setTypes(Arrays.asList("shoe park", "shop"));

        // Location object
        location loc = new location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        addPlace.setLocation(loc);
         return addPlace;
	}
	
	 public String putbody(String placeId, String newAddress) {
	        return "{\n" +
	                "\"place_id\":\"" + placeId + "\",\n" +
	                "\"address\":\"" + newAddress + "\",\n" +
	                "\"key\":\"qaclick123\"\n" +
	                "}";
	    }
	
	   public String deletebody(String placeId) {
	        return "{\n" +
	                "\"place_id\":\"" + placeId + "\"\n" +
	                "}";
	    }
}
