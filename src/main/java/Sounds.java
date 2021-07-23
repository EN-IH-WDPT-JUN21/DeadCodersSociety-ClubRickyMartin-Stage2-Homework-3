import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Random;

public class Sounds {
    public static void playSound() {
        final File dir = new File("src/main/audio");
        File[] files = dir.listFiles();
        Random rand = new Random();
        File file = files[rand.nextInt(files.length)];
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file.getPath()).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
