package com.santander.cassandra.conf;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.local.LocalCassandraFactory;
import com.github.nosan.embedded.cassandra.local.artifact.RemoteArtifactFactory;
import com.github.nosan.embedded.cassandra.test.CqlSessionConnectionFactory;
import com.github.nosan.embedded.cassandra.test.CqlSessionFactory;
import com.github.nosan.embedded.cassandra.test.junit5.CassandraExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.nio.file.Paths;
public class SessionCustom {

    /*
     * Alterar para a pasta correta da sua máquina
     */
    private static final String DIRECTORY = "C:/Cassandra";

    /*
     * Alterar para a pasta correta da sua máquina
     */
    private static final String HOME= "C:/Cassandra/cassandra_home";
    private static final String VERSION = "3.11.9";
    private static final String SCRIPT = "schema.cql";

    /**
     * Configured Cassandra Factory.
     */
    @RegisterExtension
    public static final Cassandra cassandra = new CassandraExtension(() -> {
        LocalCassandraFactory factory = new LocalCassandraFactory();
        factory.setWorkingDirectory(Paths.get(HOME));
        factory.setArtifactDirectory(Paths.get(DIRECTORY));
        Version versionTest = Version.parse(VERSION);
        factory.setVersion(versionTest);
        RemoteArtifactFactory remoteArtifactFactory = new RemoteArtifactFactory();
        factory.setArtifactFactory(remoteArtifactFactory);
        remoteArtifactFactory.setUrlFactory(new UrlCustom().getUrlFactory());

        return factory.create();
    }, new CqlSessionConnectionFactory(), CqlScript.classpath(SCRIPT));


    public static CqlSession session;

    @BeforeAll
    static void initSession() {
        session = new CqlSessionFactory().create(cassandra.getSettings());
    }

    @AfterAll
    static void closeSession() {
        if (session != null) {
            session.close();
        }
    }
}