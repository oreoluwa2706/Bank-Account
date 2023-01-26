package com.account.bankAccount.Data.Repositories;

import com.account.bankAccount.Data.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends MongoRepository<User, String> {
}
