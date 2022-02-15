package me.whale.data.dbms.repository.backend;

import me.whale.data.dbms.domain.system.user.TbAccount;
import me.whale.data.dbms.repository.CustomRepository;

import java.util.Optional;

public interface AccountRepository extends CustomRepository<TbAccount, Long> {
    Optional<TbAccount> findByAccountNo(String accountNo);
}
