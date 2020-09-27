package be.pxl.ja.streamingservice.model;

public abstract class Content {
    private String title;
    private be.pxl.h1.oef4en5.Rating maturityRating;
    private String imageUrl;

    public Content(String title, be.pxl.h1.oef4en5.Rating maturityRating) {
        this.title = title;
        this.maturityRating = maturityRating;
    }

    public be.pxl.h1.oef4en5.Rating getMaturityRating() {
        return maturityRating;
    }

    public String getTitle() {
        return title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return title;
    }
}
