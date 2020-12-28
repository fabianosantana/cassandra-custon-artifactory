package com.santander.cassandra.starter;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.local.LocalCassandraFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CassandraEmbeddedStarter {


    public static final String C_USERS_FONA = "C:/Users/fona/";
//    public static final String C_USERS_FONA = "http://artifactory.santanderbr.corp/artifactory/webapp/#/artifacts/browse/tree/General/raw-downloads/cassandra/3.11.9/";
    public static final String C_USERS_FONA_CASSANDRA_HOME = "C:/Users/fona/cassandra_home";
    public static final String VERSION = "3.11.9";

    public static void main(String[] args) {
        Path rootArtifactDirectory = Paths.get(C_USERS_FONA);
        Path cassandraHome = Paths.get(C_USERS_FONA_CASSANDRA_HOME);
        startLocal(rootArtifactDirectory, cassandraHome);
    }

    private static void startLocal(Path rootArtifactDirectory, Path workDirectory){
        LocalCassandraFactory cassandraFactory = new LocalCassandraFactory();
        cassandraFactory.setWorkingDirectory(workDirectory);
        cassandraFactory.setArtifactDirectory(rootArtifactDirectory);
        Version versionTest = Version.parse(VERSION);
        cassandraFactory.setVersion(versionTest);

        Cassandra cassandra = cassandraFactory.create();
        cassandra.start();
    }
}
