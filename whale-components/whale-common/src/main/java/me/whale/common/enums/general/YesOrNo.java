package me.whale.common.enums.general;

public enum YesOrNo {
    /**
     * true and yes
     */
    Y,
    /**
     * false and no
     */
    N,
    ;

    public static YesOrNo fromBoolean(boolean trueOrFalse) {
        return trueOrFalse ? Y : N;
    }
}
