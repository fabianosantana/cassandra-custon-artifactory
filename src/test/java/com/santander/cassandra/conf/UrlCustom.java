package com.santander.cassandra.conf;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.local.artifact.UrlFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlCustom {

    public static final String VERSION = "3.11.9";
    public static final String URL = "http://artifactory.santanderbr.corp/artifactory/webapp/#/artifacts/browse/tree/General/raw-downloads/cassandra/3.11.9/apache-cassandra-3.11.9-bin.tar.gz";
";

    private final UrlFactory url = version -> {
        URL[] acessos = new URL[1];
        acessos[0] = new URL(URL);
        return acessos;
    };

    public UrlFactory getUrlFactory() {
        try {
          this.url.create(Version.parse(VERSION));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return url;
    }

}
