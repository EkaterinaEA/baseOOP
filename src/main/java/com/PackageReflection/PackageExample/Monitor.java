package com.PackageReflection.PackageExample;

import com.Annotation.RandomInt;

import java.lang.annotation.Annotation;

public class Monitor {

        private String monitorBrand = "Dell";

        @RandomInt(min = 50, max = 100)
        private int quantity;

        @RandomInt(min = 1, max = 100)
        private int price;

        @Override
        public String toString() {
            return "Monitor{" +
                    "monitorBrand='" + monitorBrand + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }
    }

