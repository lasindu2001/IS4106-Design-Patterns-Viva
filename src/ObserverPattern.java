import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String latestIssue);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
    void publishNewIssue(String issue);
}

class Newsletter implements Subject {
    private List<Observer> subscribers;
    private String latestIssue;

    public Newsletter() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.update(latestIssue);
        }
    }

    public void publishNewIssue(String issue) {
        this.latestIssue = issue;
        notifyObservers();
    }
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String latestIssue) {
        System.out.println("Hello " + name + "! New issue published: " + latestIssue);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Newsletter newsletter = new Newsletter();

        Subscriber subscriber1 = new Subscriber("Steve Smith");
        Subscriber subscriber2 = new Subscriber("Marnus Labuschagne");

        newsletter.attach(subscriber1);
        newsletter.attach(subscriber2);

        newsletter.publishNewIssue("Best Test Duo");
        newsletter.publishNewIssue("First Ever Con. Sub");

        newsletter.detach(subscriber2);

        newsletter.publishNewIssue("Best since Bradman");
    }
}

