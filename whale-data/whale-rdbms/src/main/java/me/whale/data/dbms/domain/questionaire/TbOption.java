package me.whale.data.dbms.domain.questionaire;

import me.whale.data.dbms.domain.IdEntity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * @author weixin
 */
public class TbOption extends IdEntity {
    private static final long serialVersionUID = -7323651619041387288L;
    /**
     * id related to specific question
     */
    @NotNull
    private Long questionId;
    @NotNull
    private Integer optionSequence;
    /**
     * to identify this option as unique
     */
    @NotEmpty
    private String optionValue;
    /**
     * option content including text,image,audio,video
     */
    private String text;
    private String image;
    private String audio;
    private String video;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getOptionSequence() {
        return optionSequence;
    }

    public void setOptionSequence(Integer optionSequence) {
        this.optionSequence = optionSequence;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
