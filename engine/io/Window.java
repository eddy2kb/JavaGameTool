package engine.io;

import org.lwjgl.glfw.*;

public class Window {
    private int width, height;
    private String title;
    private long window;
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }
    public void create() {
        if(!GLFW.glfwInit()) {
            System.err.println("Error Initializing Window.");
            return;
        }
        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if(window == 0) {
            System.err.println("Error Creating Window.");
            return;
        }
        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2,
                (videoMode.height() - height) / 2);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
        GLFW.glfwSwapInterval(1);
    }
    public void update() {
        GLFW.glfwPollEvents();
    }
    public void swapBuffers() {
        GLFW.glfwSwapBuffers(window);
    }
    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(window);
    }
}
