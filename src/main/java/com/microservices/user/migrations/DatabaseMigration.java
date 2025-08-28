package com.microservices.user.migrations;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class DatabaseMigration {

    // Migration 1: Add Migration field here
//    @ChangeUnit(id = "", order = "001", author = "")
//    public static class AddUserCountField {
//
//        @Execution
//        public void addUserCountField(MongoTemplate mongoTemplate) {
//            Query query = new Query(Criteria.where("userCount").exists(false));
//            Update update = new Update().set("", 0);
//            mongoTemplate.updateMulti(query, update, "");
//        }
//
//        @RollbackExecution
//        public void rollbackAddUserCountField(MongoTemplate mongoTemplate) {
//            Update update = new Update().unset("");
//            mongoTemplate.updateMulti(new Query(), update, "");
//        }
//    }

}