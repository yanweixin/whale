package me.whale.data.elastic.domain;

import jakarta.validation.constraints.NotBlank;
import me.whale.common.enums.content.ContentStatus;

import java.util.List;

public class EsContent extends BaseEntity {
    private static final long serialVersionUID = 5316277335262663212L;
    /**
     * the title, optional
     */
    private String title;
    /**
     * actual content, cannot be blank
     */
    @NotBlank
    private String body;
    /**
     * when contentStatus is FRIENDS or SELECTED
     */
    private List<Long> visibleBy;
    /**
     * when content is post, the id is related post id
     */
    private Long originId;
    /**
     * related account id, mostly the same as createdBy
     */
    private Long accountId;
    /**
     * when user update a content, marked as OUTDATED, and insert a new document
     */
    private ContentStatus contentStatus;

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

    public List<Long> getVisibleBy() {
        return visibleBy;
    }

    public void setVisibleBy(List<Long> visibleBy) {
        this.visibleBy = visibleBy;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public ContentStatus getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(ContentStatus contentStatus) {
        this.contentStatus = contentStatus;
    }
}
