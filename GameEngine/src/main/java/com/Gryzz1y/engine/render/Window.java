package com.Gryzz1y.engine.render;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {
    private static long Window_ID;

    public static void run(int width, int height){
        if(!glfwInit()){
            throw new RuntimeException("GLFW is unable to initialize.");
        }

        Window_ID = glfwCreateWindow(width, height, "GLFW Display", 0, 0);

        if(Window_ID == 0){
            throw new RuntimeException("Failed to create GLFW winow.");
        }

        glfwMakeContextCurrent(Window_ID);
        GL.createCapabilities();

        while(!glfwWindowShouldClose(Window_ID)){
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(1f, 1f, 1f, 1f);
            
            glfwSwapBuffers(Window_ID);
        }

        glfwDestroyWindow(Window_ID);
        glfwTerminate();
    }
}
