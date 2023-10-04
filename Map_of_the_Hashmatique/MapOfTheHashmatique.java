import java.util.HashMap;
import java.util.Set;
public class MapOfTheHashmatique {

    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("One Step Closer", "I cannot take this anymore");
        trackList.put("Runaway", "Graffiti decorations");
        trackList.put("In The End", "It starts with one");
        trackList.put("Pushing Me Away", "I've lied to you");

        String title = trackList.get("Runaway");
        System.out.println(title + "\n");

        Set<String> allTracks = trackList.keySet();
        for (String key : allTracks) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}
