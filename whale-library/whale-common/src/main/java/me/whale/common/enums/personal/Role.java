package me.whale.common.enums.personal;

import java.util.Objects;

public enum Role {
    /**
     * normal user
     */
    NORMAL,
    /**
     * administrator group
     */
    ADMIN,
    /**
     * superuser
     */
    ROOT,
    ;

    public boolean isPrior(Role compareTo) {
        if (Objects.nonNull(compareTo)) {
            return this.ordinal() < compareTo.ordinal();
        }
        return true;
    }
}
