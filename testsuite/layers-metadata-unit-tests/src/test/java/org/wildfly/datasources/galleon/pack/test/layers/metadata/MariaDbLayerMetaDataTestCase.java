package org.wildfly.datasources.galleon.pack.test.layers.metadata;

import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;

public class MariaDbLayerMetaDataTestCase extends AbstractLayerMetaDataTestCase {
    private static Path nonXaWar;
    private static Path xaWar;
    private static Path nonXaJar;
    private static Path xaJar;

    @BeforeClass
    public static void createArchives() {
        nonXaWar = createWebArchive("non-xa.war", "test-ds.xml", createDatasourceXml(false, "mariadb"));
        xaWar = createWebArchive("xa.war", "test-ds.xml", createDatasourceXml(true, "mariadb"));
        nonXaJar = createJavaArchive("non-xa.jar", "test-ds.xml", createDatasourceXml(false, "mariadb"));
        xaJar = createJavaArchive("xa.jar", "test-ds.xml", createDatasourceXml(true, "mariadb"));
    }

    @Test
    public void testNonXaWar() throws Exception {
        checkLayersForArchive(nonXaWar, "mariadb-driver");
    }

    @Test
    public void testXaWar() throws Exception {
        checkLayersForArchive(xaWar, "mariadb-driver");
    }

    @Test
    public void testNonXaJar() throws Exception {
        checkLayersForArchive(nonXaJar, "mariadb-driver");
    }

    @Test
    public void testXaJar() throws Exception {
        checkLayersForArchive(xaJar, "mariadb-driver");
    }
}
