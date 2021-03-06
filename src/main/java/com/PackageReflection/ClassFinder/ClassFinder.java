package com.PackageReflection.ClassFinder;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {

    private static final char PKG_SEPARATOR = '.';

    private static final char DIR_SEPARATOR = '/';

    private static final String CLASS_FILE_SUFFIX = ".class";

    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    /**
     * Возвращает список классов в пакете
     */
    public static List<Class<?>> find(String scannedPackage) {
        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }
        File scannedDir = new File(scannedUrl.getFile());
        System.out.println(scannedDir.listFiles());
        System.out.println(scannedDir);
        List<Class<?>> classes = new ArrayList<>();
        try {
            for (File file : scannedDir.listFiles()) {
                System.out.println(file);
                classes.addAll(find(file, scannedPackage));
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        return classes;
    }

    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();
        System.out.println(file);
        if (file.isDirectory()) {
            //          if (file.list().length > 0) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
            //        }
        } else
        if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}
