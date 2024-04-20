import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 1450;
        int boardHeight = boardWidth;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();

        playMusicTest();
    }

    private static void playMusicTest() throws UnsupportedAudioFileException {
        try {
            URL musicUrl = App.class.getResource("/Boombox3.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicUrl);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
            
        }
    } 
}
