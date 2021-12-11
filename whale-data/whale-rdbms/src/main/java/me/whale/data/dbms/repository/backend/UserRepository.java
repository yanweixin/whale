package me.whale.data.dbms.repository.backend;

import me.whale.data.dbms.domain.system.user.TbUser;
import me.whale.data.dbms.repository.CustomRepository;

import java.util.Optional;

public interface UserRepository extends CustomRepository<TbUser, Long> {
    Optional<TbUser> findByUserNo(String userNo);
}
