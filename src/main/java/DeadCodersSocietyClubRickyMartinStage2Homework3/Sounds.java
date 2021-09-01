package DeadCodersSocietyClubRickyMartinStage2Homework3;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;

//class build for audio output
public class Sounds {
    public static void playSound() {
        final File dir = getAudioDirectory();

        //get files from directory
        File[] files = dir.listFiles();

        //choose random file
        int randomInt = new Random().nextInt(Objects.requireNonNull(files).length);
        File file = files[randomInt];

        //play chosen file
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file.getPath()).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            System.out.println("Clip is open: ".concat(String.valueOf(clip.isOpen())));
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound");
            ex.printStackTrace();
        }
    }

    //fetch directory where audio files are stored
    public static File getAudioDirectory() {
        try {
            URL audioDirectoryUrl = Objects.requireNonNull(Sounds.class.getClassLoader().getResource("audio"));
            return new File(audioDirectoryUrl.toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Error with getting audio/ directory", e);
        }
    }
}
