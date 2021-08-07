package me.whale.data.elastic.domain;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "content")
public class EsContent extends BaseEntity {
    private static final long serialVersionUID = 5316277335262663212L;

    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
