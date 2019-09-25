package framework.dataprovider;

public enum SearchItemProvider {

    JAVA("Java");

    private final String searchItem;

    SearchItemProvider(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getSearchItem() {
        return searchItem;
    }
}
