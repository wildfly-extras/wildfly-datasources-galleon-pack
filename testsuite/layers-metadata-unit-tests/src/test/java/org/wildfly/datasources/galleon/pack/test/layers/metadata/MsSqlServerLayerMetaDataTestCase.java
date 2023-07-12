package org.wildfly.datasources.galleon.pack.test.layers.metadata;

import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;

public class MsSqlServerLayerMetaDataTestCase extends AbstractLayerMetaDataTestCase {
    private static Path nonXaWar;
    private static Path xaWar;
    private static Path nonXaJar;
    private static Path xaJar;

    @BeforeClass
    public static void createArchives() {
        nonXaWar = createWebArchive("non-xa.war", "test-ds.xml", createDatasourceXml(false, "mssqlserver"));
        xaWar = createWebArchive("xa.war", "test-ds.xml", createDatasourceXml(true, "mssqlserver"));
        nonXaJar = createJavaArchive("non-xa.jar", "test-ds.xml", createDatasourceXml(false, "mssqlserver"));
        xaJar = createJavaArchive("xa.jar", "test-ds.xml", createDatasourceXml(true, "mssqlserver"));
    }

    @Test
    public void testNonXaWar() throws Exception {
        checkLayersForArchive(nonXaWar, "mssqlserver-driver");
    }

    @Test
    public void testXaWar() throws Exception {
        checkLayersForArchive(xaWar, "mssqlserver-driver");
    }

    @Test
    public void testNonXaJar() throws Exception {
        checkLayersForArchive(nonXaJar, "mssqlserver-driver");
    }

    @Test
    public void testXaJar() throws Exception {
        checkLayersForArchive(xaJar, "mssqlserver-driver");
    }
}
