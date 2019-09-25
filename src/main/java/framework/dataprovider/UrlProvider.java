package framework.dataprovider;

public enum UrlProvider {

    HELION("https://helion.pl/");

    private final String url;

    UrlProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
