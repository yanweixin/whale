package me.whale.common.enums.content;

public enum ContentStatus {
    /**
     * to be viewed by all people
     */
    PUBLIC,
    /**
     * can be viewed by followers
     */
    PRIVATE,
    /**
     * only can be viewed by self
     */
    SELF,
    /**
     * can be viewed by friends
     */
    FRIENDS,
    /**
     * only people being selected can view
     */
    SELECTED,
    /**
     * has been deleted
     */
    DELETED,
    /**
     * has been updated by user
     */
    OUTDATED,
    ;

}
