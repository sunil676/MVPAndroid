package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoMain {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(5, "com.sunil.payuandroidchallenge.db.model");
        addKickStarter(schema);
        new DaoGenerator().generateAll(schema, "../PayUAndroidChallenge/app/src/main/java/");
    }

    private static void addKickStarter(Schema schema) {
        Entity kickStarter = schema.addEntity("KickStarter");
        kickStarter.addIdProperty();
        kickStarter.addStringProperty("s_no").notNull();
        kickStarter.addStringProperty("amt_pledged");
        kickStarter.addStringProperty("blurb");
        kickStarter.addStringProperty("by");
        kickStarter.addStringProperty("country");
        kickStarter.addStringProperty("currency");
        kickStarter.addStringProperty("end_time");
        kickStarter.addStringProperty("location");
        kickStarter.addStringProperty("percentage");
        kickStarter.addStringProperty("num_backers");
        kickStarter.addStringProperty("state");
        kickStarter.addStringProperty("title");
        kickStarter.addStringProperty("type");
        kickStarter.addStringProperty("url");

    }
}
