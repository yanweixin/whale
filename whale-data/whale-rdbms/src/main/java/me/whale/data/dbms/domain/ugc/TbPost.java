package me.whale.data.dbms.domain.ugc;

import me.whale.common.enums.ContentStatus;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class TbPost extends BaseEntity {
    private static final long serialVersionUID = 6407068720685195874L;

    private String contentId;

    @Enumerated(EnumType.STRING)
    private ContentStatus contentStatus;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public ContentStatus getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(ContentStatus contentStatus) {
        this.contentStatus = contentStatus;
    }
}
