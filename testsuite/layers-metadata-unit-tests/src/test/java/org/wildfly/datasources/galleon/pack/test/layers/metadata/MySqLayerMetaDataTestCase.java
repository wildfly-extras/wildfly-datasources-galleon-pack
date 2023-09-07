package org.wildfly.datasources.galleon.pack.test.layers.metadata;

import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;

public class MySqLayerMetaDataTestCase extends AbstractLayerMetaDataTestCase {
    private static Path nonXaWar;
    private static Path xaWar;
    private static Path nonXaJar;
    private static Path xaJar;

    @BeforeClass
    public static void createArchives() {
        nonXaWar = createWebArchive("non-xa.war", "test-ds.xml", createDatasourceXml(false, "mysql"));
        xaWar = createWebArchive("xa.war", "test-ds.xml", createDatasourceXml(true, "mysql"));
        nonXaJar = createJavaArchive("non-xa.jar", "test-ds.xml", createDatasourceXml(false, "mysql"));
        xaJar = createJavaArchive("xa.jar", "test-ds.xml", createDatasourceXml(true, "mysql"));
    }

    @Test
    public void testNonXaWar() throws Exception {
        checkLayersForArchive(nonXaWar, "mysql-driver");
    }

    @Test
    public void testXaWar() throws Exception {
        checkLayersForArchive(xaWar, "mysql-driver");
    }

    @Test
    public void testNonXaJar() throws Exception {
        checkLayersForArchive(nonXaJar, "mysql-driver");
    }

    @Test
    public void testXaJar() throws Exception {
        checkLayersForArchive(xaJar, "mysql-driver");
    }
}
