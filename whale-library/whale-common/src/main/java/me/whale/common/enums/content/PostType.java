package me.whale.common.enums.content;

public enum PostType {
    /**
     * the user post under its own account
     */
    ORIGIN,
    /**
     * the post is submitted to another account(user or forum etc.)
     */
    SUBMIT,
    /**
     * the post is a reply to another post
     */
    REPLY,
    /**
     * the post is forwarding another post
     */
    FORWARD
}
