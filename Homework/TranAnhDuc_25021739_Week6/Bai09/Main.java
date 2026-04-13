interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

class AudioPlayer implements AudioPlayable {
    public void playAudio(String file) {
        System.out.println("Playing audio: " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    public void playVideo(String file) {
        System.out.println("Playing video: " + file);
    }
}

class MediaPlayer {
    private AudioPlayable audio;
    private VideoPlayable video;

    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audio = audio;
        this.video = video;
    }

    public void playAudio(String file) {
        audio.playAudio(file);
    }

    public void playVideo(String file) {
        video.playVideo(file);
    }
}

public class Main {
    public static void main(String[] args) {
        AudioPlayable audio = new AudioPlayer();
        VideoPlayable video = new VideoPlayer();

        MediaPlayer player = new MediaPlayer(audio, video);

        player.playAudio("song.mp3");
        player.playVideo("movie.mp4");
    }
}