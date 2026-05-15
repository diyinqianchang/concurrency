package com.abc.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Administrator
 * @Date 2025/10/1 10:45
 * @Version 1.0
 */
public class CustomClassLoader extends ClassLoader{

    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public CustomClassLoader(String classPath, ClassLoader parent) {
        super(parent);
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 1. 读取class文件字节码
            byte[] classData = loadClassData(name);
            if (classData == null) {
                throw new ClassNotFoundException("Class not found: " + name);
            }

            // 2. 调用defineClass将字节码转换为Class对象
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Failed to load class: " + name, e);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        // 将包名转换为文件路径
        String path = className.replace('.', '/') + ".class";
        String fullPath = classPath + "/" + path;
        System.out.println("fullPath "+ fullPath);

        try (InputStream ins = new FileInputStream(fullPath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;

            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        }
    }
}
