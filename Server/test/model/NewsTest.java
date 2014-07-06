/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CZM
 */
public class NewsTest {
    
    public NewsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContent method, of class News.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        News instance = new News();
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class News.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "";
        News instance = new News();
        instance.setContent(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewsId method, of class News.
     */
    @Test
    public void testGetNewsId() {
        System.out.println("getNewsId");
        News instance = new News();
        int expResult = 0;
        int result = instance.getNewsId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewsId method, of class News.
     */
    @Test
    public void testSetNewsId() {
        System.out.println("setNewsId");
        int newsId = 0;
        News instance = new News();
        instance.setNewsId(newsId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class News.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        News instance = new News();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class News.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        News instance = new News();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class News.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        News instance = new News();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class News.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        News instance = new News();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testSchemaExport() {
        // TODO review the generated test code and remove the default call to fail.
        new SchemaExport(new AnnotationConfiguration().configure()).create(true,true);
    }
}
