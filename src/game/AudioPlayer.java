package game;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.util.ResourceLoader;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {
    public static Map<String, Sound> soundMap;
    public static Map<String, Music> musicMap;

    public static void Load(){
        soundMap = new HashMap<String, Sound>();
        musicMap = new HashMap<String, Music>();
        try {
            URL ref = ResourceLoader.getResource("yeah.ogg");
            musicMap.put("Music", new Music(ref));
            ref = ResourceLoader.getResource("clic.ogg");
            soundMap.put("Sound", new Sound(ref));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
