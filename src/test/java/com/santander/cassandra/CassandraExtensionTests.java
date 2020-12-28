package com.santander.cassandra;

import org.junit.jupiter.api.Test;
import com.santander.cassandra.conf.SessionCustom;

import static org.assertj.core.api.Assertions.assertThat;
class CassandraExtensionTests extends SessionCustom {

    @Test
    void findAll() {

        assertThat(session.execute("SELECT * FROM  test.clients")).hasSize(2);
    }

}