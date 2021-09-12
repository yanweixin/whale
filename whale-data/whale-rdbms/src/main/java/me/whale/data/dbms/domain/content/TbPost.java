package me.whale.data.dbms.domain.content;

import me.whale.common.enums.content.ContentStatus;
import me.whale.common.enums.content.PostType;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class TbPost extends BaseEntity {
    private static final long serialVersionUID = 6407068720685195874L;
    /**
     * when post to home page by the creator, accountId is creator userId, that is accountId equals createdBy
     * when post to a forum by user, accountId is forum id
     * when submit post, accountId is the user id you submit to
     */
    private Long accountId;
    /**
     * the content associated with this post
     */
    private String contentId;
    /**
     * when post type is FORWARD, it is the post id being forwarded
     * when post type is REPLY, it is the post being replied to
     */
    private Long relatedPostId;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @Enumerated(EnumType.STRING)
    private ContentStatus contentStatus;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Long getRelatedPostId() {
        return relatedPostId;
    }

    public void setRelatedPostId(Long relatedPostId) {
        this.relatedPostId = relatedPostId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public ContentStatus getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(ContentStatus contentStatus) {
        this.contentStatus = contentStatus;
    }
}
