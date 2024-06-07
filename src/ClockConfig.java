public class ClockConfig {
    private final String title;
    private final String repoLink;
    private final int width;
    private final int height;
    private final int interval;

    public ClockConfig(String title, String repoLink, int width, int height, int interval) {
        this.title = title;
        this.repoLink = repoLink;
        this.width = width;
        this.height = height;
        this.interval = interval;
    }

    public String getTitle() {
        return title + " | " + repoLink;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getInterval() {
        return interval;
    }
}