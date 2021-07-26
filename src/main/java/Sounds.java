import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;

public class Sounds {
    //sounds are intended to play when something special happens, like close_win
    public static void playSound() {
        final File dir = getAudioDirectory();

        File[] files = dir.listFiles();
        int randomInt = new Random().nextInt(Objects.requireNonNull(files).length);
        File file = files[randomInt];
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file.getPath()).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound");
            ex.printStackTrace();
        }
    }

    private static File getAudioDirectory() {
        try {
            URL audioDirectoryUrl = Objects.requireNonNull(Sounds.class.getClassLoader().getResource("audio"));
            return new File(audioDirectoryUrl.toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Error with getting audio/ directory", e);
        }
    }
}
