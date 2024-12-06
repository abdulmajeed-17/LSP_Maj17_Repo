package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShapeRendererTest {
    private ShapeRenderer renderer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        renderer = new ShapeRenderer();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testRenderCircle() {
        outContent.reset();
        renderer.renderShape("circle");
        assertEquals("Drawing a Circle", outContent.toString().trim());
    }

    @Test
    void testRenderRectangle() {
        outContent.reset();
        renderer.renderShape("rectangle");
        assertEquals("Drawing a Rectangle", outContent.toString().trim());
    }

    @Test
    void testRenderTriangle() {
        outContent.reset();
        renderer.renderShape("triangle");
        assertEquals("Drawing a Triangle", outContent.toString().trim());
    }

    @Test
    void testRenderUnknownShape() {
        outContent.reset();
        renderer.renderShape("hexagon");
        assertEquals("Unknown shape type: hexagon", outContent.toString().trim());
    }
}
