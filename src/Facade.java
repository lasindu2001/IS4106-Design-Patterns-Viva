class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player is off");
    }
}


class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}


class Lights {
    public void dim(int level) {
        System.out.println("Dimming lights to " + level + "%");
    }
}


class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the movie theater...");
        dvdPlayer.off();
        amplifier.off();
        lights.dim(100);
    }
}

public class Facade {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, lights);

        homeTheater.watchMovie("Inception");

        homeTheater.endMovie();
    }
}
