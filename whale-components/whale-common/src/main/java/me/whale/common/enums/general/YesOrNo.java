package me.whale.common.enums.general;

public enum YesOrNo {
    /**
     * false and no
     */
    N,
    /**
     * true and yes
     */
    Y,
    ;

    public static YesOrNo fromBoolean(boolean trueOrFalse) {
        return trueOrFalse ? Y : N;
    }
}
